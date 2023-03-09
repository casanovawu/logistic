package com.suzz.mini.facade.user.driven;

import com.suzz.mini.dto.driven.MiniUserFocusUpdateDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;

/**
 * @author subo
 * @date 2022/8/7 0:08
 **/
public interface MiniUserFocusFacade {

    ResponseDTO update(SimpleRequest<MiniUserFocusUpdateDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
