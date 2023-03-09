package com.suzz.mini.controller;

import com.suzz.mini.convertor.PageConvertor;
import com.suzz.mini.dto.PageModuleDTO;
import com.suzz.mini.dto.PageModuleQueryDTO;
import com.suzz.mini.facade.PageFacade;
import com.suzz.mini.vo.PageModuleMapVO;
import com.suzz.mini.vo.PageModuleQueryVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author subo
 * @date 2022/5/15 18:43
 **/
@Api(tags = "页面")
@RestController
@RequestMapping(path = "/page")
public class PageController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private PageFacade pageFacade;

    @PostMapping(path = "/queryPageModule")
    @ApiOperation(value = "查询菜单下的组件名称")
    @ResponseBody
    public SimpleResponse<PageModuleMapVO> queryPageModule(@RequestBody SimpleRequest<PageModuleQueryVO> request) {
        SimpleRequest<PageModuleQueryDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, PageConvertor::convertorToPageModuleQueryDTO);
        ListResponse<PageModuleDTO> response = pageFacade.queryPageModule(simpleRequest);
        return PageConvertor.convertorToPageModuleMapVO(response);
    }
}
