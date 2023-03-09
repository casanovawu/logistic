package com.suzz.platform.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.suzz.platform.exception.ProgramException;
import lombok.Getter;
import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * redission 装饰器
 */
public class RedissonClientDecorator {

    @Getter
    private final RedissonClient redissonClient;


    public RedissonClientDecorator(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 推送单个对象至redis
     *
     * @param t   推送对象
     * @param nf  获取对象所对应name的函数
     * @param kf  获取对象所对应key元素名
     * @param <T> 推送对象类型
     */
    public <T> void put(T t, Function<T, String> nf, Function<T, String> kf) {
        push(t, nf, kf);
    }

    /**
     * 推送单个对象至redis
     *
     * @param t   推送对象
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     * @param <T> 推送对象类型
     */
    public <T> void put(T t, String name, String key) {
        push(t, name, key);
    }

    /**
     * 推送单个对象至redis
     *
     * @param t   推送对象
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     * @param <T> 推送对象类型
     */
    public <T> void putWithExpire(T t, String name, String key, long time, TimeUnit timeUnit) {
        RMap<String, T> rMap = push(t, name, key);
        rMap.expire(time, timeUnit);
    }

    /**
     * 推送单个对象至redis 带过期时间
     *
     * @param t        推送对象
     * @param nf       获取对象所对应key的函数
     * @param kf       获取对象所对应的元素名
     * @param <T>      推送对象类型
     * @param time     时间数值
     * @param timeUnit 时间单位
     */
    public <T> void putWithExpire(T t, Function<T, String> nf, Function<T, String> kf, long time, TimeUnit timeUnit) {
        RMap<String, T> rMap = push(t, nf, kf);
        rMap.expire(time, timeUnit);
    }

    /**
     * 推送列表对象至redis
     *
     * @param ts  推送对象列表
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     * @param <T> 推送对象类型
     */
    public <T> void putAll(final List<T> ts, final String name, final String key) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> put(t, name, key));
        }
    }

    /**
     * 推送列表对象至redis
     *
     * @param ts  推送对象列表
     * @param nf  获取对象所对应key的函数
     * @param kf  获取对象所对应的元素名
     * @param <T> 推送对象类型
     */
    public <T> void putAll(final List<T> ts, final Function<T, String> nf, final Function<T, String> kf) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> put(t, nf, kf));
        }
    }

    /**
     * 推送单个对象至redis 带过期时间
     *
     * @param ts        推送对象
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     * @param <T>      推送对象类型
     * @param time     时间数值
     * @param timeUnit 时间单位
     */
    public <T> void putWithExpire(List<T> ts, final String name, final String key,
                                  final long time, final TimeUnit timeUnit) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> putWithExpire(t, name, key, time, timeUnit));
        }
    }

    /**
     * 推送单个对象至redis 带过期时间
     *
     * @param ts        推送对象
     * @param nf       获取对象所对应key的函数
     * @param kf       获取对象所对应的元素名
     * @param <T>      推送对象类型
     * @param time     时间数值
     * @param timeUnit 时间单位
     */
    public <T> void putWithExpire(List<T> ts, Function<T, String> nf, Function<T, String> kf,
                                  final long time, final TimeUnit timeUnit) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> putWithExpire(t, nf, kf, time, timeUnit));
        }
    }

    /**
     * 删除单个name下所有对象
     *
     * @param t   推送对象
     * @param nf  获取对象所对应name的函数
     * @param <T> 推送对象类型
     */
    public <T> void delete(T t, Function<T, String> nf) {
        boolean valid = Objects.nonNull(t) && Objects.nonNull(nf);
        ProgramException.assertTrue(valid, "删除参数异常");
        String name = nf.apply(t);
        del(name);
    }

    /**
     * 删除单个name下所有对象
     *
     * @param name redis name
     */
    public void delete(String name) {
        del(name);
    }

    /**
     * 删除列表对象至redis
     *
     * @param ts  推送对象列表
     * @param nf  获取对象所对应key的函数
     * @param <T> 推送对象类型
     */
    public <T> void delete(final List<T> ts, final Function<T, String> nf) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> delete(t, nf));
        }
    }

    /**
     * 批量删除单个name下所有对象s
     *
     * @param names redis name
     */
    public void delete(List<String> names) {
        if (CollUtil.isNotEmpty(names)) {
            names.forEach(this::delete);
        }
    }

    /**
     * 删除单个的指定行对象至redis
     *
     * @param t   推送对象
     * @param nf  获取对象所对应key的函数
     * @param kf  获取对象所对应的元素名
     * @param <T> 推送对象类型
     */
    public <T> void deleteKey(T t, Function<T, String> nf, Function<T, String> kf) {
        boolean valid = Objects.nonNull(t) && Objects.nonNull(nf) && Objects.nonNull(kf);
        ProgramException.assertTrue(valid, "删除参数异常");
        String name = nf.apply(t);
        String key = kf.apply(t);
        delKey(name, key);
    }

    /**
     * 删除单个的指定行对象至redis
     *
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     */
    public void deleteKey(String name, String key) {
        delKey(name, key);
    }

    /**
     * 删除多个个的指定行对象至redis
     *
     * @param ts  删除对象
     * @param nf  获取对象所对应key的函数
     * @param kf  获取对象所对应的元素名
     * @param <T> 推送对象类型
     */
    public <T> void deleteKey(final List<T> ts, final Function<T, String> nf, final Function<T, String> kf) {
        if (CollUtil.isNotEmpty(ts)) {
            ts.forEach(t -> deleteKey(t, nf, kf));
        }
    }

    /**
     * 查询单个的指定行对象至redis
     *
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     */
    @SuppressWarnings("unchecked")
    public <T> T query(String name, String key, Class<T> clazz){
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(StrUtil.isNotBlank(key), "数据对应的key为空");
        Object o = redissonClient.getMap(name).get(key);
        if(Objects.nonNull(o) && o.getClass().isAssignableFrom(clazz)){
            return (T)o;
        } else {
            return null;
        }
    }

    /**
     * 查询多个的指定行对象至redis
     *
     * @param name  获取对象所对应name
     * @param list  获取对象所对应key的集合
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryForBatch(String name, List<String> list, Class<T> clazz){
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(CollUtil.isNotEmpty(list), "数据对应的key为空");
        List<T> result = new ArrayList<>();
        for (String key : list) {
            Object o = redissonClient.getMap(name).get(key);
            if (Objects.nonNull(o) && o.getClass().isAssignableFrom(clazz)) {
                result.add((T) o);
            }
        }
        return result;
    }

    /**
     * 推送 Set 集合元素
     * @param name redis key name
     * @param set 集合内容
     */
    public <T> void putSet(String name, Set<T> set) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(CollUtil.isNotEmpty(set), "数据对应的集合为空");
        RSet<T> rSet = redissonClient.getSet(name);
        rSet.addAll(set);
    }


    /**
     * 推送 Set 集合元素
     * @param name redis key name
     * @param t 集合内容
     */
    public <T> void putSet(String name, T t) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(Objects.nonNull(t), "数据为空");
        RSet<T> rSet = redissonClient.getSet(name);
        rSet.add(t);
    }

    /**
     * 删除 Set 集合元素
     * @param name redis key name
     * @param set 集合内容
     */
    public <T> void removeSet(String name, Set<T> set) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(CollUtil.isNotEmpty(set), "数据对应的集合为空");
        RSet<T> rSet = redissonClient.getSet(name);
        rSet.removeAll(set);
    }


    /**
     * 删除 Set 集合元素
     * @param name redis key name
     * @param t 集合内容
     */
    public <T> void removeSet(String name, T t) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(Objects.nonNull(t), "数据为空");
        RSet<T> rSet = redissonClient.getSet(name);
        rSet.remove(t);
    }


    /**
     * 清空 Set 集合元素
     * @param name redis key name
     */
    public void clear(String name) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        RSet<?> rSet = redissonClient.getSet(name);
        rSet.clear();
    }

    /**
     * 获取name对应的集合信息
     */
    public <T> Set<T> get(String name, Class<T> clazz){
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        Set<Object> set =  redissonClient.getSet(name).readAll();
        return set.stream().filter(clazz::isInstance).map(e -> (T)e).collect(Collectors.toSet());
    }

    /**
     * 推送单个对象至redis
     *
     * @param t   推送对象
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     * @param <T> 推送对象类型
     */
    private <T> RMap<String, T> push(T t, String name, String key) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        ProgramException.assertTrue(StrUtil.isNotBlank(key), "数据对应的key为空");
        RMap<String, T> rMap = redissonClient.getMap(name);
        rMap.put(key, t);
        return rMap;
    }

    /**
     * 推送单个对象至redis
     *
     * @param t   推送对象
     * @param nf  获取对象所对应key的函数
     * @param kf  获取对象所对应的元素名
     * @param <T> 推送对象类型
     */
    private <T> RMap<String, T> push(T t, Function<T, String> nf, Function<T, String> kf) {
        boolean valid = Objects.nonNull(t) && Objects.nonNull(nf) && Objects.nonNull(kf);
        ProgramException.assertTrue(valid, "推送参数异常");
        String name = nf.apply(t);
        String key = kf.apply(t);
        return push(t, name, key);
    }

    /**
     * 删除单个name下所有对象
     *
     * @param name  获取对象所对应key的函数
     */
    private void del(String name) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的name为空");
        redissonClient.getMap(name).delete();
    }

    /**
     * 删除单个的指定行对象至redis
     *
     * @param name  获取对象所对应name
     * @param key  获取对象所对应key
     */
    private void delKey(String name, String key) {
        ProgramException.assertTrue(StrUtil.isNotBlank(name), "数据对应的key为空");
        ProgramException.assertTrue(StrUtil.isNotBlank(key), "数据对应的element为空");
        redissonClient.getMap(name).remove(key);
    }

}