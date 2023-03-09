package com.suzz.mini.facade;

import com.suzz.mini.dto.SysConfigDTO;
import com.suzz.mini.dto.SysConfigDeleteDTO;
import com.suzz.mini.dto.SysConfigQueryDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;

/**
 * @author subo
 * @date 2022/8/22 22:14
 **/
public interface SysConfigFacade {

    ListResponse<SysConfigDTO> queryList(SimpleRequest<SysConfigQueryDTO> request);

    ResponseDTO saveOrUpdate(SimpleRequest<SysConfigDTO> request);

    ResponseDTO delete(SimpleRequest<SysConfigDeleteDTO> request);
}
