package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.CityLangCondition;
import com.suzz.mini.domain.organization.CityLang;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityLangMapper {

    List<CityLang> queryList(CityLangCondition condition);
}