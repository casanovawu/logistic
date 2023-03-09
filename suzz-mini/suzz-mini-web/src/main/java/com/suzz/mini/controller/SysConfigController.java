package com.suzz.mini.controller;


import com.suzz.mini.convertor.SysConfigConvertor;
import com.suzz.mini.dto.SysConfigDTO;
import com.suzz.mini.dto.SysConfigDeleteDTO;
import com.suzz.mini.dto.SysConfigQueryDTO;
import com.suzz.mini.facade.SysConfigFacade;
import com.suzz.mini.vo.SysConfigDeleteVO;
import com.suzz.mini.vo.SysConfigQueryResultVO;
import com.suzz.mini.vo.SysConfigQueryVO;
import com.suzz.mini.vo.SysConfigVO;
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
 * 系统配置信息
 */
@Api(tags = "系统配置信息")
@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

	@DubboReference(timeout = DubboReferenceFacade.TIMEOUT, lazy = DubboReferenceFacade.LAZY, retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
	private SysConfigFacade sysConfigFacade;

	@PostMapping("/queryList")
	@ApiOperation(value = "所有配置列表", notes = "所有配置列表")
	public SimpleResponse<SysConfigQueryResultVO> queryList(@RequestBody @Valid SimpleRequest<SysConfigQueryVO> request){
		SimpleRequest<SysConfigQueryDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, SysConfigConvertor::convertorSysConfigQueryDTO);
		ListResponse<SysConfigDTO> response = sysConfigFacade.queryList(simpleRequest);
		return new SimpleResponse<>(SysConfigConvertor.convertorSysConfigQueryResultVO(response));
	}

	@PostMapping("/saveOrUpdate")
	@ApiOperation(value = "保存配置", notes = "保存修改配置")
	public ResponseDTO saveOrUpdate(@RequestBody @Valid SimpleRequest<SysConfigVO> request){
		SimpleRequest<SysConfigDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, SysConfigConvertor::convertorSysConfigDTO);
		return sysConfigFacade.saveOrUpdate(simpleRequest);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除配置", notes = "删除配置")
	public ResponseDTO delete(@RequestBody @Valid SimpleRequest<SysConfigDeleteVO> request){
		SimpleRequest<SysConfigDeleteDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, SysConfigConvertor::convertorSysConfigDeleteDTO);
		return sysConfigFacade.delete(simpleRequest);
	}
}
