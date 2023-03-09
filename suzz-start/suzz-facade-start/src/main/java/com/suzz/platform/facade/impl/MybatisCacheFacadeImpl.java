package com.suzz.platform.facade.impl;

import com.suzz.platform.config.MybatisCacheManager;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.facade.MybatisCacheFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.redisson.api.RMap;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author subo
 * @date 2022/8/14 10:46
 **/
@DubboService(interfaceClass = MybatisCacheFacade.class)
@Slf4j
public class MybatisCacheFacadeImpl implements MybatisCacheFacade {

    @Resource(name = "mybatisCacheManager")
    private MybatisCacheManager mybatisCacheManager;

    @Override
    public ResponseDTO clearCache(List<String> cacheIds) {
        if (cacheIds.size() > 0) {
            for (String cacheId : cacheIds) {
                RMap<Object, Object> cache = MybatisCacheManager.getCache(cacheId);
                if (cache != null) {
                    cache.clear();
                    mybatisCacheManager.cleatCacheId(cacheId);
                    log.info(cacheId + "缓存清理完成");
                } else {
                    log.info(cacheId + "缓存未建立，无需清理");
                }
            }
        }
        return new ResponseDTO();
    }

    @Override
    public List<String> queryCacheList() {
        List<String> list = new ArrayList<>();
        list.addAll(mybatisCacheManager.getCacheIds());
        return list;
    }
}
