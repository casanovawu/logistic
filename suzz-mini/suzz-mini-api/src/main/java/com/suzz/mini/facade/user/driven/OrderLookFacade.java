package com.suzz.mini.facade.user.driven;

import com.suzz.mini.dto.driven.OrderLookUpdateDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;

/**
 * @author subo
 * @date 2022/8/7 14:57
 **/
public interface OrderLookFacade {

    ResponseDTO update(SimpleRequest<OrderLookUpdateDTO> orderLookUpdateDTO) throws ApplicationException, BusinessException, ProgramException;
}
