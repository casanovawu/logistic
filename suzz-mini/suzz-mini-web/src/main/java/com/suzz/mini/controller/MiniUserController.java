package com.suzz.mini.controller;

import com.suzz.mini.convertor.MiniUserConvertor;
import com.suzz.mini.dto.*;
import com.suzz.mini.facade.user.MiniUserFacade;
import com.suzz.mini.vo.*;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022/5/2 14:17
 **/
@Api(tags = "小程序用户")
@RestController
@RequestMapping(path = "/user")
public class MiniUserController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private MiniUserFacade miniUserFacade;

    @GetMapping(path = "/getSession")
    @ApiOperation(value = "获取session")
    @ResponseBody
    public SimpleResponse<MiniUserSessionVO> getSession(@RequestParam("code") String code) {
        SimpleResponse<MiniUserSessionDTO> response = miniUserFacade.getSession(code);
        return ControllerConvertUtil.successForSimple(response, MiniUserConvertor::convertorToMiniUserSessionVO);
    }

    @GetMapping("/checkRegister")
    @ApiOperation(value= "查询是否注册")
    public SimpleResponse<Boolean> checkRegister(@RequestParam("openId") String openId){
        return miniUserFacade.checkRegister(openId);
    }

    @PostMapping("/auth")
    @ApiOperation(value= "小程序用户授权")
    public SimpleResponse<MiniUseAuthInfoVO> auth(@RequestBody @Valid SimpleRequest<MiniUserAuthReqVO> request){
        SimpleRequest<MiniUserAuthReqDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, MiniUserConvertor::convertorToMiniUserAuthReqDTO);
        SimpleResponse<MiniUserAuthInfoDTO> response = miniUserFacade.auth(simpleRequest);
        return ControllerConvertUtil.successForSimple(response, MiniUserConvertor::convertorToMiniUseInfoVO);
    }

    @PostMapping("/queryInfo")
    @ApiOperation(value= "查询用户信息")
    public SimpleResponse<MiniUserDetailInfoVO> queryInfo(@RequestBody @Valid SimpleRequest<MiniUserDetailReqVO> request){
        SimpleRequest<MiniUserDetailReqDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, MiniUserConvertor::convertorToMiniUserDetailReqDTO);
        SimpleResponse<MiniUserDetailInfoDTO> response = miniUserFacade.queryInfo(simpleRequest);
        return ControllerConvertUtil.successForSimple(response, MiniUserConvertor::convertorToMiniUserDetailInfoVO);
    }

    @PostMapping("/update")
    @ApiOperation(value= "修改用户信息")
    public SimpleResponse<MiniUseAuthInfoVO> update(@RequestBody @Valid SimpleRequest<MiniUserUpdateReqVO> request){
        SimpleRequest<MiniUserUpdateReqDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, MiniUserConvertor::convertorToMiniUserUpdateReqDTO);
        SimpleResponse<MiniUserAuthInfoDTO> response = miniUserFacade.update(simpleRequest);
        return ControllerConvertUtil.successForSimple(response, MiniUserConvertor::convertorToMiniUseInfoVO);
    }
}
