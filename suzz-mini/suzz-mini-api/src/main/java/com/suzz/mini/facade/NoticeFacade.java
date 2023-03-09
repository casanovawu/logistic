package com.suzz.mini.facade;

import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2022/5/15 19:55
 **/
public interface NoticeFacade {

    SimpleResponse<String> query() throws ApplicationException, BusinessException, ProgramException;
}
