package com.suzz.mini.facade.impl.driven;

import com.suzz.mini.domain.MiniUserFocus;
import com.suzz.mini.dto.driven.MiniUserFocusUpdateDTO;
import com.suzz.mini.facade.user.driven.MiniUserFocusFacade;
import com.suzz.mini.serivce.MiniUserFocusService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.vo.request.SimpleRequest;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author subo
 * @date 2022/8/7 0:10
 **/
@DubboService(interfaceClass = MiniUserFocusFacade.class)
@Api(tags = "miniUserFocusFacadeImpl")
public class MiniUserFocusFacadeImpl implements MiniUserFocusFacade {

    @Autowired
    private MiniUserFocusService miniUserFocusService;

    @Override
    public ResponseDTO update(SimpleRequest<MiniUserFocusUpdateDTO> request) {
        MiniUserFocus miniUserFocus = MiniUserFocus.toMiniUserFocus(request.getReqDtos());
        miniUserFocusService.updateStatus(miniUserFocus);
        return new ResponseDTO();
    }
}
