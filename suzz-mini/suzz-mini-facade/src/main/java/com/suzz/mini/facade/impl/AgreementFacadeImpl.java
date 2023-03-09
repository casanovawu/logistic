package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.Agreement;
import com.suzz.mini.dto.AgreementDTO;
import com.suzz.mini.facade.AgreementFacade;
import com.suzz.mini.serivce.AgreementService;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author subo
 * @date 2023/1/4 21:30
 **/
@DubboService(interfaceClass = AgreementFacade.class)
@Api(tags = "dictionaryFacadeImpl")
public class AgreementFacadeImpl implements AgreementFacade {

    @Autowired
    private AgreementService agreementService;

    @Override
    public SimpleResponse<AgreementDTO> queryInfo(SimpleRequest<Integer> simpleRequest) {
        SimpleResponse<AgreementDTO> simpleResponse=new SimpleResponse<>();
        Agreement agreement = agreementService.getBaseMapper().selectById(simpleRequest.getReqDtos());
        if(Objects.nonNull(agreement)){
            AgreementDTO agreementDTO=new AgreementDTO();
            agreementDTO.setName(agreement.getName());
            agreementDTO.setText(agreement.getText());
            simpleResponse.setData(agreementDTO);
        }
        return simpleResponse;
    }
}
