package com.suzz.mini.convertor.driven;

import com.suzz.mini.dto.driven.MiniUserFocusUpdateDTO;
import com.suzz.mini.vo.driven.MiniUserFocusUpdateVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/8/7 0:06
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MiniUserFocusConvertor {

    public static MiniUserFocusUpdateDTO convertoToMiniUserFocusUpdateDTO(MiniUserFocusUpdateVO miniUserFocusUpdateVO){
        MiniUserFocusUpdateDTO miniUserFocusUpdateDTO = new MiniUserFocusUpdateDTO();
        miniUserFocusUpdateDTO.setMiniUserId(miniUserFocusUpdateVO.getMiniUserId());
        miniUserFocusUpdateDTO.setMiniUserFocusId(miniUserFocusUpdateVO.getMiniUserFocusId());
        miniUserFocusUpdateDTO.setIsFocus(miniUserFocusUpdateVO.getIsFocus());
        return miniUserFocusUpdateDTO;
    }
}
