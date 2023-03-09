package com.suzz.platform.config;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author subo
 * @date 2022/8/14 10:12
 **/
@Component("mybatisCacheManager")
@Slf4j
public class MybatisCacheManager {

    private static RedissonClient client;

    private final static Map<String, RMap<Object, Object>> ALL = new ConcurrentHashMap<>();

    @Autowired
    @Synchronized
    public void setClient(RedissonClient client){
        if(MybatisCacheManager.client == null && client != null){
            MybatisCacheManager.client = client;
        }
    }

    public static RedissonClient getClient() {
        return client;
    }

    @Synchronized
    public static RMap<Object, Object> getCache(String id) {

        RMap<Object, Object> cache = ALL.get(id);
        if(cache == null ){
            try {
                cache = client.getMap(id);
                ALL.put(id, cache);
            } catch (Exception e) {
                log.error("获取缓存失败",e);
            }
        }
        return cache;
    }

    public Set<String> getCacheIds(){
        return ALL.keySet();
    }

    public void cleatCacheId(String cacheId){
         ALL.remove(cacheId);
    }
}
