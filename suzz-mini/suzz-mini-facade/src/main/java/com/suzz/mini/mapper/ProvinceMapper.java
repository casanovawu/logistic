package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.ProvinceCondition;
import com.suzz.mini.domain.organization.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {

    List<Province> queryList(ProvinceCondition provinceCondition);

}