package com.suzz.platform.util;

import cn.hutool.core.collection.CollUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LogOperationThreadLocal {

    private final static ThreadLocal<Map<String, String>> LOG_CONTENT_THREAD_LOCAL = new ThreadLocal<>();

    public static void put(String content, String key){
        Map<String, String> map = LOG_CONTENT_THREAD_LOCAL.get();
        if(Objects.isNull(map)){
            map = new HashMap<>();
        }
        map.put(key, content);
        LOG_CONTENT_THREAD_LOCAL.set(map);
    }
    public static Map<String, String> get(){
        return LOG_CONTENT_THREAD_LOCAL.get();
    }

    public static boolean hasLog(){
        return CollUtil.isNotEmpty(LOG_CONTENT_THREAD_LOCAL.get());
    }

    public static void clear(){
        LOG_CONTENT_THREAD_LOCAL.remove();
    }

}
