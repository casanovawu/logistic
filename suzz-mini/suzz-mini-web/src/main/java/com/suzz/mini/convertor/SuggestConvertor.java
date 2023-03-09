package com.suzz.mini.convertor;

import com.suzz.mini.dto.SuggestSubmitDTO;
import com.suzz.mini.vo.SuggestSubmitVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/8/7 21:30
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuggestConvertor {

    public static SuggestSubmitDTO toSuggestSubmitDTO(SuggestSubmitVO suggestSubmitVO){
        SuggestSubmitDTO suggestSubmitDTO = new SuggestSubmitDTO();
        suggestSubmitDTO.setMiniSuggestUserId(suggestSubmitVO.getMiniSuggestUserId());
        suggestSubmitDTO.setOrderId(suggestSubmitVO.getOrderId());
        suggestSubmitDTO.setType(suggestSubmitVO.getType());
        suggestSubmitDTO.setContent(suggestSubmitVO.getContent());
        suggestSubmitDTO.setContactName(suggestSubmitVO.getContactName());
        suggestSubmitDTO.setContactPhone(suggestSubmitVO.getContactPhone());
        suggestSubmitDTO.setPictureList(suggestSubmitVO.getPictureList());
        return suggestSubmitDTO;
    }
}
