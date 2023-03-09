package com.suzz.platform.facade;

import com.suzz.platform.dto.ResponseDTO;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/14 10:41
 **/
public interface MybatisCacheFacade {

   ResponseDTO clearCache(List<String> cacheIds);

   List<String> queryCacheList();
}
