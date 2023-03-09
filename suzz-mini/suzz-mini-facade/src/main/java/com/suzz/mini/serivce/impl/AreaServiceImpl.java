package com.suzz.mini.serivce.impl;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.domain.condition.AreaCondition;
import com.suzz.mini.domain.condition.AreaLangCondition;
import com.suzz.mini.domain.organization.Area;
import com.suzz.mini.domain.organization.AreaLang;
import com.suzz.mini.mapper.AreaLangMapper;
import com.suzz.mini.mapper.AreaMapper;
import com.suzz.mini.serivce.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/5/15 16:55
 **/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private AreaLangMapper areaLangMapper;

    @Override
    public List<Area> queryList(AreaCondition areaCondition) {
        List<Area> areas = areaMapper.queryList(areaCondition);
        if(CollUtil.isNotEmpty(areas)){
            extendAreaLang(areas,areaCondition.getLang());
        }
        return areas;
    }

    private void extendAreaLang(List<Area> areas, String lang) {
        List<Integer> areaIds = areas.stream().map(Area::getId).collect(Collectors.toList());
        AreaLangCondition areaLangCondition = AreaLangCondition.builder().areaIds(areaIds).lang(lang).build();
        List<AreaLang> areaLangs = areaLangMapper.queryList(areaLangCondition);
        Map<Integer, List<AreaLang>> areaLangMap = areaLangs.stream().collect(Collectors.groupingBy(AreaLang::getFkArea));
        areas.forEach(a -> {
            List<AreaLang> areaLangExist = areaLangMap.get(a.getId());
            if (CollUtil.isNotEmpty(areaLangExist)) {
                a.setAreaLang(areaLangExist.get(0));
            }
        });
    }
}
