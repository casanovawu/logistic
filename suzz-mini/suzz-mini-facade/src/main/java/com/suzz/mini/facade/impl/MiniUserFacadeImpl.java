package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.MiniUser;
import com.suzz.mini.domain.MiniUserSession;
import com.suzz.mini.dto.*;
import com.suzz.mini.facade.user.MiniUserFacade;
import com.suzz.mini.serivce.MiniUserService;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/5/2 15:06
 **/
@DubboService(interfaceClass =MiniUserFacade.class)
@Api(tags = "miniUserFacadeImpl")
public class MiniUserFacadeImpl implements MiniUserFacade {

    @Autowired
    private MiniUserService miniUserService;

    @Override
    public SimpleResponse<MiniUserSessionDTO> getSession(String code) {
        MiniUserSession session = miniUserService.getSession(code);
        return FacadeConvertUtil.success(session,MiniUserSession::toMiniUserSessionDTO);
    }

    @Override
    public SimpleResponse<Boolean> checkRegister(String openId) throws ApplicationException {
        return new SimpleResponse<>(miniUserService.checkExist(openId));
    }

    @Override
    public SimpleResponse<MiniUserAuthInfoDTO> auth(SimpleRequest<MiniUserAuthReqDTO> request) throws ApplicationException {
        MiniUser miniUser = MiniUser.toMiniUserByAuth(request.getReqDtos());
        MiniUser auth = miniUserService.auth(miniUser);
        return FacadeConvertUtil.success(auth,MiniUser::toMiniUseInfoDTO);
    }

    @Override
    public SimpleResponse<MiniUserDetailInfoDTO> queryInfo(SimpleRequest<MiniUserDetailReqDTO> request) throws ApplicationException {
        MiniUser miniUser = miniUserService.selectByPrimaryKey(request.getReqDtos().getMiniUserId());
        return FacadeConvertUtil.success(miniUser,MiniUser::toMiniUserDetailInfoDTO);
    }

    @Override
    public SimpleResponse<MiniUserAuthInfoDTO> update(SimpleRequest<MiniUserUpdateReqDTO> request) throws ApplicationException {
        MiniUser miniUser = MiniUser.toMiniUserByUpdate(request.getReqDtos());
        MiniUser update = miniUserService.update(miniUser);
        return FacadeConvertUtil.success(update,MiniUser::toMiniUseInfoDTO);
    }
}
