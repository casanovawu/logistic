package com.suzz.platform.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;

import org.springframework.util.DigestUtils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author subo
 * @date 2022/8/13 11:29
 **/
@Slf4j
public class MybatisRedisCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private String id;

    public MybatisRedisCache(final String id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        log.info("Redis Cache id " + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (value != null) {
            MybatisCacheManager.getCache(id).put(getKeyToMD5(key.toString()), value);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            if (key != null) {
                return MybatisCacheManager.getCache(id).get(getKeyToMD5(key.toString()));
            }
        } catch (Exception e) {
            log.error("redis ");
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try {
            if (key != null) {
                return MybatisCacheManager.getCache(id).remove(getKeyToMD5(key.toString()));
            }
        } catch (Exception e) {
            log.error("redis cache remove error:"+id+":"+key);
        }
        return null;
    }

    @Override
    public void clear() {
        log.info("Flush redis cache:"+id);
        MybatisCacheManager.getCache(id).clear();
    }

    @Override
    public int getSize() {
        return MybatisCacheManager.getCache(id).size();
    }

    public String getKeyToMD5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
