package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.condition.SysConfigCondition;
import com.suzz.mini.domain.config.SysConfig;
import com.suzz.mini.dto.SysConfigDTO;
import com.suzz.mini.dto.SysConfigDeleteDTO;
import com.suzz.mini.dto.SysConfigQueryDTO;
import com.suzz.mini.facade.SysConfigFacade;
import com.suzz.mini.serivce.SysConfigService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/22 23:21
 **/
@DubboService(interfaceClass = SysConfigFacade.class)
@Api(tags = "sysConfigFacadeImpl")
public class SysConfigFacadeImpl implements SysConfigFacade {

    @Autowired
    private SysConfigService sysConfigService;

    @Override
    public ListResponse<SysConfigDTO> queryList(SimpleRequest<SysConfigQueryDTO> request) {
        SysConfigCondition sysConfigCondition=new SysConfigCondition();
        sysConfigCondition.setKeyList(request.getReqDtos().getKeyList());
        List<SysConfig> sysConfigs = sysConfigService.queryList(sysConfigCondition);
        return FacadeConvertUtil.successForList(sysConfigs,SysConfig::convertTOSysConfigDTO);
    }

    @Override
    public ResponseDTO saveOrUpdate(SimpleRequest<SysConfigDTO> request) {
        SysConfig sysConfig = SysConfig.convertToSysConfig(request.getReqDtos());
        sysConfigService.createOrUpdate(sysConfig);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO delete(SimpleRequest<SysConfigDeleteDTO> request) {
        SysConfig sysConfig = SysConfig.convertToSysConfig(request.getReqDtos());
        sysConfigService.delete(sysConfig);
        return new ResponseDTO();
    }
}
