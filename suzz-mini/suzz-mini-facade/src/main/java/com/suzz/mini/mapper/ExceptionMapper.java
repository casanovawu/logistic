package com.suzz.mini.mapper;

import com.suzz.mini.domain.Exception;
import com.suzz.mini.domain.condition.ExceptionCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExceptionMapper {

    List<Exception> queryList(ExceptionCondition exceptionCondition);
}