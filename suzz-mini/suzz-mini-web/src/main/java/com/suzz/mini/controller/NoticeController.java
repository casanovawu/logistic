package com.suzz.mini.controller;

import com.suzz.mini.facade.NoticeFacade;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author subo
 * @date 2022/5/15 18:43
 **/
@Api(tags = "通知")
@RestController
@RequestMapping(path = "/notice")
public class NoticeController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private NoticeFacade noticeFacade;

    @PostMapping(path = "/query")
    @ApiOperation(value = "查询菜单下的组件名称")
    @ResponseBody
    public SimpleResponse<String> query() {
        return noticeFacade.query();
    }
}
