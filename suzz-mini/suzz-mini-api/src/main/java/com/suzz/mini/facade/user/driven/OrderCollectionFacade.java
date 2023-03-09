package com.suzz.mini.facade.user.driven;

import com.suzz.mini.dto.driven.OrderCollectionUpdateDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;

/**
 * @author subo
 * @date 2022/8/7 1:21
 **/
public interface OrderCollectionFacade {

    ResponseDTO update(SimpleRequest<OrderCollectionUpdateDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
