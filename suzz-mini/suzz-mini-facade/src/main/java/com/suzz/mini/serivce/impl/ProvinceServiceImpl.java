package com.suzz.mini.serivce.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.suzz.mini.domain.condition.CityCondition;
import com.suzz.mini.domain.condition.ProvinceCondition;
import com.suzz.mini.domain.condition.ProvinceLangCondition;
import com.suzz.mini.domain.organization.Area;
import com.suzz.mini.domain.organization.City;
import com.suzz.mini.domain.organization.Province;
import com.suzz.mini.domain.organization.ProvinceLang;
import com.suzz.mini.mapper.ProvinceLangMapper;
import com.suzz.mini.mapper.ProvinceMapper;
import com.suzz.mini.serivce.CityService;
import com.suzz.mini.serivce.ProvinceService;
import com.suzz.platform.util.LangContent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/5/15 15:46
 **/
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private ProvinceLangMapper ProvinceLangMapper;

    @Autowired
    private CityService cityService;

    @Override
    public List<Province> queryAll(ProvinceCondition provinceCondition) {
        List<Province> provinces = provinceMapper.queryList(provinceCondition);
        if (CollUtil.isNotEmpty(provinces)) {
            extendProvinceLang(provinces,provinceCondition.getLang());
            extendCityList(provinces,provinceCondition.getLang());
        }
        return provinces;
    }

    @Override
    public String queryNameByCode(String code) {
        if(StrUtil.isNotBlank(code) && code.length()==6){
            StringBuilder sb=new StringBuilder();
            String lang = "chinese";
            ProvinceCondition provinceCondition=new ProvinceCondition();
            String provinceId = code.substring(0, 2);
            Integer provinceIdToInt = Integer.valueOf(provinceId);
            provinceCondition.setId(provinceIdToInt);
            provinceCondition.setLang(lang);
            List<Province> provinces = provinceMapper.queryList(provinceCondition);
            if(CollUtil.isNotEmpty(provinces)){
                extendProvinceLang(provinces,lang);
                sb.append(provinces.get(0).getProvinceLang().getName());
                String cityCode = code.substring(2, 4);
                Integer cityCodeToInt = Integer.valueOf(cityCode);
                String areaCode = code.substring(4, 6);
                Integer areaCodeToInt = Integer.valueOf(areaCode);
                CityCondition cityCondition = CityCondition.builder().provinceId(provinceIdToInt).code(cityCodeToInt).lang(lang).areaCode(areaCodeToInt).build();
                List<City> cities = cityService.queryList(cityCondition);
                if(CollUtil.isNotEmpty(cities)){
                    City city = cities.get(0);
                    sb.append(city.getCityLang().getName());
                    if(CollUtil.isNotEmpty(city.getAreaList())){
                        Area area = city.getAreaList().get(0);
                        sb.append(area.getAreaLang().getName());
                        return sb.toString();
                    }
                }
            }

        }
        return null;
    }

    private void extendProvinceLang(List<Province> provinces,String lang) {
        List<Integer> provinceIds = provinces.stream().map(Province::getId).collect(Collectors.toList());
        ProvinceLangCondition provinceLangCondition = ProvinceLangCondition.builder().provinceIds(provinceIds).Lang(lang).build();
        List<ProvinceLang> provinceLangs = ProvinceLangMapper.queryList(provinceLangCondition);
        Map<Integer, List<ProvinceLang>> provinceLangMap = provinceLangs.stream().collect(Collectors.groupingBy(ProvinceLang::getFkProvince));
        provinces.forEach(a -> {
            List<ProvinceLang> provinceLangExist = provinceLangMap.get(a.getId());
            if (CollUtil.isNotEmpty(provinceLangExist)) {
                a.setProvinceLang(provinceLangExist.get(0));
            }
        });
    }

    private void extendCityList(List<Province> provinces,String lang) {
        List<Integer> provinceIds = provinces.stream().map(Province::getId).collect(Collectors.toList());
        CityCondition cityCondition = CityCondition.builder().provinceIds(provinceIds).lang(lang).build();
        List<City> cities = cityService.queryList(cityCondition);
        if (CollUtil.isNotEmpty(cities)) {
            Map<Integer, List<City>> cityMap = cities.stream().collect(Collectors.groupingBy(City::getFkProvince));
            provinces.forEach(a -> {
                List<City> cityExist = cityMap.get(a.getId());
                a.setCityList(cityExist);
            });
        }
    }
}
