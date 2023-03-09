package com.suzz.mini.controller.driven;

import com.suzz.mini.convertor.driven.MiniUserFocusConvertor;
import com.suzz.mini.convertor.driven.OrderConvertor;
import com.suzz.mini.dto.driven.MiniUserFocusUpdateDTO;
import com.suzz.mini.facade.user.driven.DrivenOrderFacade;
import com.suzz.mini.facade.user.driven.MiniUserFocusFacade;
import com.suzz.mini.vo.driven.MiniUserFocusUpdateVO;
import com.suzz.platform.constant.DubboReferenceFacade;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.ControllerConvertUtil;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author subo
 * @date 2022/8/6 23:59
 **/
@Api(tags = "关注")
@RestController
@RequestMapping(path = "/mini/focus")
public class MiniUserFocusController {

    @DubboReference(timeout = DubboReferenceFacade.TIMEOUT,lazy = DubboReferenceFacade.LAZY,retries = DubboReferenceFacade.RETRIES,check = DubboReferenceFacade.CHECK)
    private MiniUserFocusFacade miniUserFocusFacade;

    @PostMapping(path = "/update")
    @ApiOperation(value = "关注/取消关注")
    @ResponseBody
    public ResponseDTO update(@RequestBody @Valid SimpleRequest<MiniUserFocusUpdateVO> request) {
        SimpleRequest<MiniUserFocusUpdateDTO> simpleRequest = ControllerConvertUtil.convertForSimple(request, MiniUserFocusConvertor::convertoToMiniUserFocusUpdateDTO);
        return miniUserFocusFacade.update(simpleRequest);
    }
}
