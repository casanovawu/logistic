package com.suzz.mini.facade.user.driven;

import com.suzz.mini.dto.driven.*;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2022/8/7 0:08
 **/
public interface LineSubscribeFacade {

    ResponseDTO create(SimpleRequest<LineSubscribeCreateDTO> request) throws ApplicationException, BusinessException, ProgramException;

    ResponseDTO update(SimpleRequest<LineSubscribeUpdateDTO> request) throws ApplicationException, BusinessException, ProgramException;

    ListResponse<LineSubscribeQueryInfoDTO> queryList(SimpleRequest<LineSubscribeQueryListDTO> request) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<LineSubscribeQueryInfoDTO> queryOne(SimpleRequest<LineSubscribeQueryDetailDTO> request) throws ApplicationException, BusinessException, ProgramException;

    ResponseDTO delete(SimpleRequest<LineSubscribeDeleteDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
