package com.suzz.mini.mapper;

import com.suzz.mini.domain.Dictionary;
import com.suzz.mini.domain.condition.DictionaryCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryMapper {

    List<Dictionary> queryList(DictionaryCondition dictionaryCondition);
}