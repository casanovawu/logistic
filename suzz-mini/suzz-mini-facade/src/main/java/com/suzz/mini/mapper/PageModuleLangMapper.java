package com.suzz.mini.mapper;

import com.suzz.mini.domain.PageModuleLang;
import com.suzz.mini.domain.condition.PageModuleLangCondition;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageModuleLangMapper {

    PageModuleLang queryInfo(PageModuleLangCondition pageModuleLangCondition);

}