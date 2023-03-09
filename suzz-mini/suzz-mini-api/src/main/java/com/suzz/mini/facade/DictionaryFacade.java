package com.suzz.mini.facade;

import com.suzz.mini.dto.DictionaryDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;


/**
 * @author subo
 * @date 2022/5/19 13:49
 **/
public interface DictionaryFacade {

    ListResponse<DictionaryDTO> queryList(SimpleRequest<String> code) throws ApplicationException, BusinessException, ProgramException;
}
