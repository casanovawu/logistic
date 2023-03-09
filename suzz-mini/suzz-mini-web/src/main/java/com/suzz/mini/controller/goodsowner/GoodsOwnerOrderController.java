package com.suzz.mini.controller.goodsowner;

import com.suzz.mini.convertor.goodsowner.OrderConvertor;
import com.suzz.mini.dto.goodsowner.*;
import com.suzz.mini.facade.user.goodsowner.OrderFacade;
import com.suzz.mini.vo.goodsowner.*;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022/5/4 13:26
 **/
@Api(tags = "货主端订单")
@RestController
@RequestMapping(path = "/goodsowner/order")
public class GoodsOwnerOrderController {


    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private OrderFacade orderFacade;

    @PostMapping(path = "/publish")
    @ApiOperation(value = "发布")
    @ResponseBody
    public SimpleResponse<Integer> publish(@RequestBody SimpleRequest<OrderPublishVO> request) {
        SimpleRequest<OrderPublishDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderConvertor::convertorToOrderPublishDTO);
        return orderFacade.publish(simpleRequest);
    }

    @PostMapping(path = "/myPublish")
    @ApiOperation(value = "我的发布")
    @ResponseBody
    public PageResponse<OrderMyPublishInfoVO> myPublish(@RequestBody @Valid PageRequest<OrderMyPublishQueryVO> request) {
        PageRequest<OrderMyPublishQueryDTO> pageRequest = ControllerConvertUtil.convertForPage(request, OrderConvertor::convertorToOrderMyPublishQueryDTO);
        PageResponse<OrderMyPublishInfoDTO> pageResponse = orderFacade.myPublish(pageRequest);
        return ControllerConvertUtil.successForPage(pageResponse,OrderConvertor::convertorToOrderMyPublishInfoDTO);
    }

    @PostMapping(path = "/publishDetail")
    @ApiOperation(value = "发布详情")
    @ResponseBody
    public SimpleResponse<OrderPublishDetailInfoVO> publishDetail(@RequestBody SimpleRequest<OrderPublishDetailQueryVO> request) {
        SimpleRequest<OrderPublishDetailQueryDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderConvertor::convertorToOrderPublishDetailQueryVO);
        SimpleResponse<OrderPublishDetailInfoDTO> simpleResponse = orderFacade.publishDetail(simpleRequest);
       return ControllerConvertUtil.successForSimple(simpleResponse,OrderConvertor::convertorToOrderPublishDetailInfoVO);
    }

    @PostMapping(path = "/updateDetail")
    @ApiOperation(value = "修改详情")
    @ResponseBody
    public ResponseDTO updateDetail(@RequestBody SimpleRequest<OrderUpdatePublishVO> request) {
        SimpleRequest<OrderUpdatePublishDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderConvertor::convertorToOrderUpdatePublishDTO);
        return orderFacade.updatePublish(simpleRequest);
    }

    @PostMapping(path = "/updateStatus")
    @ApiOperation(value = "修改状态")
    @ResponseBody
    public ResponseDTO updateStatus(@RequestBody SimpleRequest<OrderUpdateStatusVO> request) {
        SimpleRequest<OrderUpdateStatusDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, OrderConvertor::convertoToOrderUpdateStatusDTO);
        return orderFacade.updateStatus(simpleRequest);
    }
}
