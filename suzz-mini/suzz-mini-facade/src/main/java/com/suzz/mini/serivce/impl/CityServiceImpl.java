package com.suzz.mini.serivce.impl;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.domain.condition.AreaCondition;
import com.suzz.mini.domain.condition.CityCondition;
import com.suzz.mini.domain.condition.CityLangCondition;
import com.suzz.mini.domain.condition.ProvinceLangCondition;
import com.suzz.mini.domain.organization.*;
import com.suzz.mini.mapper.CityLangMapper;
import com.suzz.mini.mapper.CityMapper;
import com.suzz.mini.serivce.AreaService;
import com.suzz.mini.serivce.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/5/15 16:31
 **/
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityLangMapper cityLangMapper;

    @Autowired
    private AreaService areaService;

    @Override
    public List<City> queryList(CityCondition cityCondition) {
        List<City> cities = cityMapper.queryList(cityCondition);
        if(CollUtil.isNotEmpty(cities)){
            extendCityLang(cities,cityCondition.getLang());
            extendAreaList(cities,cityCondition.getLang(),cityCondition.getAreaCode());
        }
        return cities;
    }

    private void extendCityLang(List<City> cities,String lang) {
        List<Integer> cityIds = cities.stream().map(City::getId).collect(Collectors.toList());
        CityLangCondition cityLangCondition = CityLangCondition.builder().cityIds(cityIds).lang(lang).build();
        List<CityLang> cityLangs = cityLangMapper.queryList(cityLangCondition);
        Map<Integer, List<CityLang>> cityLangMap = cityLangs.stream().collect(Collectors.groupingBy(CityLang::getFkCity));
        cities.forEach(a -> {
            List<CityLang> cityLangExist = cityLangMap.get(a.getId());
            if (CollUtil.isNotEmpty(cityLangExist)) {
                a.setCityLang(cityLangExist.get(0));
            }
        });
    }

    private void extendAreaList(List<City> cities,String lang,Integer areaCode) {
        List<Integer> cityIds = cities.stream().map(City::getId).collect(Collectors.toList());
        AreaCondition areaCondition = AreaCondition.builder().cityIds(cityIds).lang(lang).code(areaCode).build();
        List<Area> areas = areaService.queryList(areaCondition);
        if (CollUtil.isNotEmpty(areas)) {
            Map<Integer, List<Area>> areaMap = areas.stream().collect(Collectors.groupingBy(Area::getFkCity));
            cities.forEach(a -> {
                List<Area> areaExist = areaMap.get(a.getId());
                a.setAreaList(areaExist);
            });
        }
    }
}
