package com.suzz.platform.service;

import com.suzz.platform.domain.log.LogRecord;

/**
 * 操作日志记录服务
 */
public interface OperationLogService {

    /**
     * 记录操作日志
     */
    default void save(LogRecord record){

    }

    default LogRecord convert(String key){
        return null;
    }

}
