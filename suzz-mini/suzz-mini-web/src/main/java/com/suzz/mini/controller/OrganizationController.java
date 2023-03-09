package com.suzz.mini.controller;

import com.suzz.mini.convertor.OrganizationConvertor;
import com.suzz.mini.dto.ProvinceDTO;
import com.suzz.mini.dto.ProvinceQueryDTO;
import com.suzz.mini.facade.ProvinceFacade;
import com.suzz.mini.vo.OrganizationInfoVO;
import com.suzz.mini.vo.OrganizationQueryVO;
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
 * @date 2022/5/14 15:44
 **/
@Api(tags = "组织架构")
@RestController
@RequestMapping(path = "/organization")
public class OrganizationController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private ProvinceFacade provinceFacade;

    @PostMapping(path = "/queryList")
    @ApiOperation(value = "查询所有省市级连")
    @ResponseBody
    public SimpleResponse<OrganizationInfoVO> publish(@RequestBody SimpleRequest<OrganizationQueryVO> request) {
        SimpleRequest<ProvinceQueryDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrganizationConvertor::convertorToProvinceQueryDTO);
        ListResponse<ProvinceDTO> response = provinceFacade.queryAll(simpleRequest);
        return OrganizationConvertor.convertorToOrganizationInfoVO(response);
    }
}
