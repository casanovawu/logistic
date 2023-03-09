package com.suzz.platform.controller;

import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.facade.MybatisCacheFacade;
import com.suzz.platform.vo.request.ListRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author subo
 * @date 2022/8/14 10:31
 **/
@RestController
@Api(tags = "缓存控制")
@Slf4j
public class CacheManagerController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,
            lazy = DubboReferenceFacade.LAZY,
            retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private MybatisCacheFacade mybatisCacheFacade;



    @ApiOperation("清理MyBatis缓存")
    @ResponseBody
    @RequestMapping(value="/cache/mybatis/clear",method=RequestMethod.DELETE)
    public ResponseDTO cleanMyBatisCache(@RequestBody @Valid@ApiParam(value="MyBatis缓存清理请求",required=true) ListRequest<String> request){
        return mybatisCacheFacade.clearCache(request.getData());
    }

    @ApiOperation(value="查询当前缓存情况")
    @ResponseBody
    @RequestMapping(value="/cache/view",method= RequestMethod.POST)
    public ListResponse<String> getCacheList(){
        ListResponse<String> response = new ListResponse<>();
        List<String> list = mybatisCacheFacade.queryCacheList();
        response.setData(list);
        return response;
    }
}
