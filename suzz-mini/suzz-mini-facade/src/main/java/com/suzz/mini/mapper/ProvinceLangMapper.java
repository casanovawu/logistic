package com.suzz.mini.mapper;

import com.suzz.mini.domain.condition.ProvinceLangCondition;
import com.suzz.mini.domain.organization.ProvinceLang;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceLangMapper {

    List<ProvinceLang> queryList(ProvinceLangCondition provinceLangCondition);
}