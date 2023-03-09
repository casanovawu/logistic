package com.suzz.mini.facade.user;

import com.suzz.mini.dto.*;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2022/5/2 15:02
 **/
public interface MiniUserFacade {

    SimpleResponse<MiniUserSessionDTO> getSession(String code) throws ApplicationException;

    SimpleResponse<Boolean> checkRegister( String openId) throws ApplicationException;

    SimpleResponse<MiniUserAuthInfoDTO> auth(SimpleRequest<MiniUserAuthReqDTO> request) throws ApplicationException;

    SimpleResponse<MiniUserDetailInfoDTO> queryInfo(SimpleRequest<MiniUserDetailReqDTO> request) throws ApplicationException;

    SimpleResponse<MiniUserAuthInfoDTO> update(SimpleRequest<MiniUserUpdateReqDTO> request) throws ApplicationException;
}
