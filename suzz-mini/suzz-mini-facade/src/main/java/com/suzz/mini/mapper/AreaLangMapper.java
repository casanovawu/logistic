package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.AreaLangCondition;
import com.suzz.mini.domain.organization.AreaLang;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaLangMapper {

    List<AreaLang> queryList(AreaLangCondition areaLangCondition);

}