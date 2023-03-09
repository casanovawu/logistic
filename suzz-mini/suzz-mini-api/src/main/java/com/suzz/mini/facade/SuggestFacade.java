package com.suzz.mini.facade;

import com.suzz.mini.dto.SuggestSubmitDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;

/**
 * @author subo
 * @date 2022/8/7 21:33
 **/
public interface SuggestFacade {

    ResponseDTO submit(SimpleRequest<SuggestSubmitDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException;
}
