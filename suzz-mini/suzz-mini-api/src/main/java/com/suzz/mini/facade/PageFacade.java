package com.suzz.mini.facade;

import com.suzz.mini.dto.PageModuleDTO;
import com.suzz.mini.dto.PageModuleQueryDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;

/**
 * @author subo
 * @date 2022/5/15 19:55
 **/
public interface PageFacade {

    ListResponse<PageModuleDTO> queryPageModule(SimpleRequest<PageModuleQueryDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException;
}
