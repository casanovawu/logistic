package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.condition.ProvinceCondition;
import com.suzz.mini.domain.organization.Province;
import com.suzz.mini.dto.ProvinceDTO;
import com.suzz.mini.dto.ProvinceQueryDTO;
import com.suzz.mini.facade.ProvinceFacade;
import com.suzz.mini.serivce.ProvinceService;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 17:11
 **/
@DubboService(interfaceClass = ProvinceFacade.class)
@Api(tags = "provinceFacadeImpl")
public class ProvinceFacadeImpl implements ProvinceFacade {

    @Autowired
    private ProvinceService provinceService;

    @Override
    public ListResponse<ProvinceDTO> queryAll(SimpleRequest<ProvinceQueryDTO> request) {
        ProvinceCondition provinceCondition = ProvinceCondition.toProvinceCondition(request.getReqDtos());
        List<Province> provinces = provinceService.queryAll(provinceCondition);
        return FacadeConvertUtil.successForList(provinces,Province::toProvinceDTO);
    }
}
