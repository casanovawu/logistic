package com.suzz.mini.facade.user.driven;

import com.suzz.mini.dto.driven.OrderSearchDetailInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchDetailQueryDTO;
import com.suzz.mini.dto.driven.OrderSearchInfoDTO;
import com.suzz.mini.dto.driven.OrderSearchQueryDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;

/**
 * @author subo
 * @date 2022/5/4 13:33
 **/
public interface DrivenOrderFacade {

    PageResponse<OrderSearchInfoDTO> search(PageRequest<OrderSearchQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<OrderSearchDetailInfoDTO> searchDetail(SimpleRequest<OrderSearchDetailQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;

}
