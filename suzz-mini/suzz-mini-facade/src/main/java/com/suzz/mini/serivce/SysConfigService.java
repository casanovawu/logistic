package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.condition.SysConfigCondition;
import com.suzz.mini.domain.config.SysConfig;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/22 23:22
 **/
public interface SysConfigService extends IService<SysConfig> {

    String getValue(String key);

    List<SysConfig> queryList(SysConfigCondition condition);

    void createOrUpdate(SysConfig sysConfig);

    void delete(SysConfig sysConfig);
}
