package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.AreaCondition;
import com.suzz.mini.domain.organization.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    List<Area> queryList(AreaCondition condition);

}