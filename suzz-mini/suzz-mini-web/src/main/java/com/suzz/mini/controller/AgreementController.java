package com.suzz.mini.controller;

import com.suzz.mini.dto.AgreementDTO;
import com.suzz.mini.facade.AgreementFacade;
import com.suzz.mini.vo.AgreementVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/5/15 18:43
 **/
@Api(tags = "协议")
@RestController
@RequestMapping(path = "/agreement")
public class AgreementController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private AgreementFacade agreementFacade;

    @PostMapping(path = "/query")
    @ApiOperation(value = "查询协议详情")
    @ResponseBody
    public SimpleResponse<AgreementVO> query(@RequestBody SimpleRequest<Integer> simpleRequest) {
        SimpleResponse<AgreementVO> response=new SimpleResponse<>();
        SimpleResponse<AgreementDTO> simpleResponse = agreementFacade.queryInfo(simpleRequest);
        if(Objects.nonNull(simpleResponse.getData())){
            AgreementDTO data = simpleResponse.getData();
            AgreementVO agreementVO=new AgreementVO();
            agreementVO.setName(data.getName());
            agreementVO.setText(data.getText());
            response.setData(agreementVO);
        }
        return response;
    }
}
