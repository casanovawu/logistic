package com.suzz.mini.controller;

import com.suzz.mini.convertor.DictionaryConvertor;
import com.suzz.mini.dto.DictionaryDTO;
import com.suzz.mini.facade.DictionaryFacade;
import com.suzz.mini.vo.DictionaryVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author subo
 * @date 2022/5/19 13:45
 **/
@Api(tags = "字典")
@RestController
@RequestMapping(path = "/dic")
public class DictionaryController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private DictionaryFacade dictionaryFacade;

    @PostMapping(path = "/queryList")
    @ApiOperation(value = "查询字典值")
    @ResponseBody
    public ListResponse<DictionaryVO> queryList(@RequestBody SimpleRequest<String> simpleRequest) {
        ListResponse<DictionaryDTO> response = dictionaryFacade.queryList(simpleRequest);
        return ControllerConvertUtil.successForList(response, DictionaryConvertor::convertorToDictionaryVO);
    }
}
