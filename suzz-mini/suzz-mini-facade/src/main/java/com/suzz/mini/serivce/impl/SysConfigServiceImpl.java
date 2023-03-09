package com.suzz.mini.serivce.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.domain.condition.SysConfigCondition;
import com.suzz.mini.domain.config.SysConfig;
import com.suzz.mini.mapper.SysConfigMapper;
import com.suzz.mini.serivce.SysConfigService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/8/22 23:24
 **/
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig>  implements SysConfigService {


    @Override
    @Cacheable(cacheNames = "SysConfig", key = "#key")
    public String getValue(String key) {
        SysConfig sysConfig = this.baseMapper.queryByKey(key);
        if(Objects.nonNull(sysConfig)){
            return sysConfig.getParamValue();
        }
        return null;
    }

    @Override
    public List<SysConfig> queryList(SysConfigCondition condition) {
        List<SysConfig> sysConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<SysConfig>().in(CollectionUtil.isNotEmpty(condition.getKeyList()),SysConfig::getParamKey,condition.getKeyList()));
        return sysConfigs;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames="SysConfig",key="#key")
    })
    public void createOrUpdate(SysConfig sysConfig) {

    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames="SysConfig",key="#key")
    })
    public void delete(SysConfig sysConfig) {

    }
}
