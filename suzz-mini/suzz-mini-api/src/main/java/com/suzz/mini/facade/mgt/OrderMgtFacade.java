package com.suzz.mini.facade.mgt;

import com.suzz.mini.dto.mgt.OrderAuditDTO;
import com.suzz.mini.dto.mgt.OrderMgtDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;

public interface OrderMgtFacade {

    SimpleResponse<OrderMgtDTO> selectOrderById(SimpleRequest<OrderMgtDTO> dto) throws ApplicationException, BusinessException, ProgramException;

    ListResponse<OrderMgtDTO> selectOrderList(SimpleRequest<OrderMgtDTO> dto) throws ApplicationException, BusinessException, ProgramException;

    PageResponse<OrderMgtDTO> selectOrderListPage(PageRequest<OrderMgtDTO> dto) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<Integer> updateOrder(SimpleRequest<OrderMgtDTO> order) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<Integer> audit(SimpleRequest<OrderAuditDTO> request) throws ApplicationException, BusinessException, ProgramException;
}
