package com.suzz.mini.facade.user.goodsowner;

import com.suzz.mini.dto.goodsowner.*;
import com.suzz.platform.dto.ResponseDTO;
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
public interface OrderFacade {

    SimpleResponse<Integer> publish(SimpleRequest<OrderPublishDTO> request) throws ApplicationException, BusinessException, ProgramException;

    PageResponse<OrderMyPublishInfoDTO> myPublish(PageRequest<OrderMyPublishQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;

    SimpleResponse<OrderPublishDetailInfoDTO> publishDetail(SimpleRequest<OrderPublishDetailQueryDTO> request) throws ApplicationException, BusinessException, ProgramException;

    ResponseDTO updatePublish(SimpleRequest<OrderUpdatePublishDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException;

    ResponseDTO updateStatus(SimpleRequest<OrderUpdateStatusDTO> simpleRequest) throws ApplicationException, BusinessException, ProgramException;
}
