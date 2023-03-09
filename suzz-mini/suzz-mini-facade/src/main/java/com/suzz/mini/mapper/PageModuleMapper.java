package com.suzz.mini.mapper;

import com.suzz.mini.domain.PageModule;
import com.suzz.mini.domain.condition.PageModuleCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageModuleMapper {

    List<PageModule> queryList(PageModuleCondition condition);

}