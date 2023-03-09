package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.Suggest;
import com.suzz.mini.dto.SuggestSubmitDTO;
import com.suzz.mini.facade.SuggestFacade;
import com.suzz.mini.serivce.SuggestService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/8/7 21:33
 **/
@DubboService(interfaceClass = SuggestFacade.class)
@Api(tags = "suggestFacadeImpl")
public class SuggestFacadeImpl implements SuggestFacade {

    @Autowired
    private SuggestService suggestService;

    @Override
    public ResponseDTO submit(SimpleRequest<SuggestSubmitDTO> simpleRequest) {
        Suggest suggest = Suggest.toSuggest(simpleRequest.getReqDtos());
        suggestService.submit(suggest);
        return new ResponseDTO();
    }
}
