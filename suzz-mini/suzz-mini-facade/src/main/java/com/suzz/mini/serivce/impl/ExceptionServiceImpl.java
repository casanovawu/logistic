package com.suzz.mini.serivce.impl;

import com.suzz.mini.domain.Exception;
import com.suzz.mini.domain.condition.ExceptionCondition;
import com.suzz.mini.mapper.ExceptionMapper;
import com.suzz.mini.serivce.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/19 23:15
 **/
@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    private ExceptionMapper exceptionMapper;

    @Override
    public List<Exception> queryList(ExceptionCondition exceptionCondition) {
        return exceptionMapper.queryList(exceptionCondition);
    }
}
