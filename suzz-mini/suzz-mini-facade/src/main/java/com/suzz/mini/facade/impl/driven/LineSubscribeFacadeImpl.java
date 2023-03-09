package com.suzz.mini.facade.impl.driven;

import com.suzz.mini.domain.LineSubscribe;
import com.suzz.mini.domain.condition.LineSubscribeCondition;
import com.suzz.mini.dto.driven.*;
import com.suzz.mini.facade.user.driven.LineSubscribeFacade;
import com.suzz.mini.serivce.LineSubscribeService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/7 14:56
 **/
@DubboService(interfaceClass = LineSubscribeFacade.class)
@Api(tags = "lineSubscribeFacadeImpl")
public class LineSubscribeFacadeImpl implements LineSubscribeFacade {

    @Autowired
    private LineSubscribeService lineSubscribeService;

    @Override
    public ResponseDTO create(SimpleRequest<LineSubscribeCreateDTO> request) {
        LineSubscribe lineSubscribe = LineSubscribe.toCreateLineSubscribe(request.getReqDtos());
        lineSubscribeService.insert(lineSubscribe);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO update(SimpleRequest<LineSubscribeUpdateDTO> request) {
        LineSubscribe lineSubscribe = LineSubscribe.toUpdateLineSubscribe(request.getReqDtos());
        lineSubscribeService.update(lineSubscribe);
        return new ResponseDTO();
    }

    @Override
    public ListResponse<LineSubscribeQueryInfoDTO> queryList(SimpleRequest<LineSubscribeQueryListDTO> request) {
        LineSubscribeCondition lineSubscribeCondition = LineSubscribeCondition.toLineSubscribeCondition(request.getReqDtos());
        List<LineSubscribe> lineSubscribes = lineSubscribeService.queryList(lineSubscribeCondition);
        return FacadeConvertUtil.successForList(lineSubscribes,LineSubscribe::toLineSubscribeQueryInfoDTO);
    }

    @Override
    public SimpleResponse<LineSubscribeQueryInfoDTO> queryOne(SimpleRequest<LineSubscribeQueryDetailDTO> request) {
        LineSubscribeCondition lineSubscribeCondition = LineSubscribeCondition.toLineSubscribeCondition(request.getReqDtos());
        LineSubscribe lineSubscribe = lineSubscribeService.queryOne(lineSubscribeCondition);
        return FacadeConvertUtil.success(lineSubscribe,LineSubscribe::toLineSubscribeQueryInfoDTO);
    }

    @Override
    public ResponseDTO delete(SimpleRequest<LineSubscribeDeleteDTO> request) throws ApplicationException, BusinessException, ProgramException {
        LineSubscribe lineSubscribe = LineSubscribe.toLineSubscribe(request.getReqDtos());
        lineSubscribeService.delete(lineSubscribe);
        return new ResponseDTO();
    }
}
