package com.suzz.mini.serivce;


import com.suzz.mini.domain.Exception;
import com.suzz.mini.domain.condition.ExceptionCondition;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/19 23:13
 **/
public interface ExceptionService {

    List<Exception> queryList(ExceptionCondition exceptionCondition);
}
