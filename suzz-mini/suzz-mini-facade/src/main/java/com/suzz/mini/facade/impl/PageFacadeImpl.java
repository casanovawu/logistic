package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.PageModule;
import com.suzz.mini.domain.condition.PageModuleCondition;
import com.suzz.mini.dto.PageModuleDTO;
import com.suzz.mini.dto.PageModuleQueryDTO;
import com.suzz.mini.facade.PageFacade;
import com.suzz.mini.serivce.PageService;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 19:58
 **/
@DubboService(interfaceClass = PageFacade.class)
@Api(tags = "pageFacadeImpl")
public class PageFacadeImpl implements PageFacade {

    @Autowired
    private PageService pageService;

    @Override
    public ListResponse<PageModuleDTO> queryPageModule(SimpleRequest<PageModuleQueryDTO> simpleRequest) {
        PageModuleCondition pageModuleCondition = PageModuleCondition.toPageModuleCondition(simpleRequest.getReqDtos());
        List<PageModule> pageModules = pageService.queryPageModuleList(pageModuleCondition);
        return FacadeConvertUtil.successForList(pageModules,PageModule::toPageModuleDTO);
    }
}
