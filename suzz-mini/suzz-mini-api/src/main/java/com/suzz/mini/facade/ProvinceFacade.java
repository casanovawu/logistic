package com.suzz.mini.facade;

import com.suzz.mini.dto.ProvinceDTO;
import com.suzz.mini.dto.ProvinceQueryDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;

/**
 * @author subo
 * @date 2022/5/15 17:07
 **/
public interface ProvinceFacade {

    ListResponse<ProvinceDTO> queryAll(SimpleRequest<ProvinceQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
