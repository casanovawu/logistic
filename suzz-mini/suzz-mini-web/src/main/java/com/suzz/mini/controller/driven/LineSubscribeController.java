package com.suzz.mini.controller.driven;

import com.suzz.mini.convertor.driven.LineSubscribeConvertor;
import com.suzz.mini.dto.driven.*;
import com.suzz.mini.facade.user.driven.LineSubscribeFacade;
import com.suzz.mini.vo.driven.*;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022-08-09 19:02
 **/
@Api(tags = "线路订阅")
@RestController
@RequestMapping(path = "/line/subscribe")
public class LineSubscribeController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private LineSubscribeFacade lineSubscribeFacade;

    @PostMapping(path = "/create")
    @ApiOperation(value = "新增")
    @ResponseBody
    public ResponseDTO create(@RequestBody @Valid SimpleRequest<LineSubscribeCreateVO> request) {
        SimpleRequest<LineSubscribeCreateDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, LineSubscribeConvertor::convertoToMiniUserFocusUpdateDTO);
        return lineSubscribeFacade.create(simpleRequest);
    }

    @PostMapping(path = "/update")
    @ApiOperation(value = "修改")
    @ResponseBody
    public ResponseDTO update(@RequestBody @Valid SimpleRequest<LineSubscribeUpdateVO> request) {
        SimpleRequest<LineSubscribeUpdateDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, LineSubscribeConvertor::convertoToMiniUserFocusUpdateDTO);
        return lineSubscribeFacade.update(simpleRequest);
    }

    @PostMapping(path = "/delete")
    @ApiOperation(value = "修改")
    @ResponseBody
    public ResponseDTO delete(@RequestBody @Valid SimpleRequest<LineSubscribeDeleteVO> request) {
        SimpleRequest<LineSubscribeDeleteDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, LineSubscribeConvertor::convertoLineSubscribeDeleteDTO);
        return lineSubscribeFacade.delete(simpleRequest);
    }

    @PostMapping(path = "/queryList")
    @ApiOperation(value = "查询")
    @ResponseBody
    public ListResponse<LineSubscribeQueryInfoVO> queryList(@RequestBody @Valid SimpleRequest<LineSubscribeQueryListVO> request) {
        SimpleRequest<LineSubscribeQueryListDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, LineSubscribeConvertor::convertoLineSubscribeQueryListDTO);
        ListResponse<LineSubscribeQueryInfoDTO> lineSubscribeQueryInfoDTOListResponse = lineSubscribeFacade.queryList(simpleRequest);
        return ControllerConvertUtil.successForList(lineSubscribeQueryInfoDTOListResponse,LineSubscribeConvertor::convertoLineSubscribeQueryInfoVO);
    }

    @PostMapping(path = "/queryOne")
    @ApiOperation(value = "查询")
    @ResponseBody
    public SimpleResponse<LineSubscribeQueryInfoVO> queryOne(@RequestBody @Valid SimpleRequest<LineSubscribeQueryDetailVO> request) {
        SimpleRequest<LineSubscribeQueryDetailDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, LineSubscribeConvertor::convertoLineSubscribeQueryDetailDTO);
        SimpleResponse<LineSubscribeQueryInfoDTO> lineSubscribeQueryInfoDTOSimpleResponse = lineSubscribeFacade.queryOne(simpleRequest);
        return ControllerConvertUtil.successForSimple(lineSubscribeQueryInfoDTOSimpleResponse,LineSubscribeConvertor::convertoLineSubscribeQueryInfoVO);
    }
}
