package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.CityCondition;
import com.suzz.mini.domain.organization.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    List<City> queryList(CityCondition condition);

}