package com.suzz.mini.controller;

import com.suzz.mini.convertor.SuggestConvertor;
import com.suzz.mini.dto.SuggestSubmitDTO;
import com.suzz.mini.facade.SuggestFacade;
import com.suzz.mini.vo.SuggestSubmitVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author subo
 * @date 2022/8/7 21:16
 **/
@Api(tags = "反馈与建议")
@RestController
@RequestMapping(path = "/suggest")
public class SuggestController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT, lazy = DubboReferenceFacade.LAZY, retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private SuggestFacade suggestFacade;

    @RequestMapping(value = "/submit", method = {RequestMethod.POST})
    @ApiOperation(value = "提交")
    @ResponseBody
    public ResponseDTO submit(@RequestBody SimpleRequest<SuggestSubmitVO> request){
        SimpleRequest<SuggestSubmitDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, SuggestConvertor::toSuggestSubmitDTO);
        return suggestFacade.submit(simpleRequest);
    }
}
