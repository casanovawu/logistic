package com.suzz.mini.convertor.driven;

import cn.hutool.core.collection.CollectionUtil;
import com.suzz.mini.dto.driven.*;
import com.suzz.mini.vo.driven.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

/**
 * @author subo
 * @date 2022/8/7 0:06
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineSubscribeConvertor {

    public static LineSubscribeCreateDTO convertoToMiniUserFocusUpdateDTO(LineSubscribeCreateVO lineSubscribeCreateVO){
        LineSubscribeCreateDTO lineSubscribeCreateDTO = new LineSubscribeCreateDTO();
        lineSubscribeCreateDTO.setMiniUserId(lineSubscribeCreateVO.getMiniUserId());
        lineSubscribeCreateDTO.setDepartureAreaCode(lineSubscribeCreateVO.getDepartureAreaCode());
        lineSubscribeCreateDTO.setArriveAreaCode(lineSubscribeCreateVO.getArriveAreaCode());
        lineSubscribeCreateDTO.setCartTypeList(lineSubscribeCreateVO.getCartTypeList());
        return lineSubscribeCreateDTO;
    }

    public static LineSubscribeUpdateDTO convertoToMiniUserFocusUpdateDTO(LineSubscribeUpdateVO lineSubscribeUpdateVO){
        LineSubscribeUpdateDTO lineSubscribeUpdateDTO = new LineSubscribeUpdateDTO();
        lineSubscribeUpdateDTO.setId(lineSubscribeUpdateVO.getId());
        lineSubscribeUpdateDTO.setDepartureAreaCode(lineSubscribeUpdateVO.getDepartureAreaCode());
        lineSubscribeUpdateDTO.setArriveAreaCode(lineSubscribeUpdateVO.getArriveAreaCode());
        lineSubscribeUpdateDTO.setCartTypeList(lineSubscribeUpdateVO.getCartTypeList());
        return lineSubscribeUpdateDTO;
    }

    public static LineSubscribeQueryListDTO convertoLineSubscribeQueryListDTO(LineSubscribeQueryListVO lineSubscribeQueryListVO){
        LineSubscribeQueryListDTO lineSubscribeQueryListDTO = new LineSubscribeQueryListDTO();
        lineSubscribeQueryListDTO.setMiniUserId(lineSubscribeQueryListVO.getMiniUserId());
        return lineSubscribeQueryListDTO;
    }

    public static LineSubscribeQueryDetailDTO convertoLineSubscribeQueryDetailDTO(LineSubscribeQueryDetailVO lineSubscribeQueryDetailVO){
        LineSubscribeQueryDetailDTO lineSubscribeQueryDetailDTO = new LineSubscribeQueryDetailDTO();
        lineSubscribeQueryDetailDTO.setId(lineSubscribeQueryDetailVO.getId());
        return lineSubscribeQueryDetailDTO;
    }

    public static LineSubscribeDeleteDTO convertoLineSubscribeDeleteDTO(LineSubscribeDeleteVO lineSubscribeDeleteVO){
        LineSubscribeDeleteDTO lineSubscribeDeleteDTO = new LineSubscribeDeleteDTO();
        lineSubscribeDeleteDTO.setId(lineSubscribeDeleteVO.getId());
        return lineSubscribeDeleteDTO;
    }


    public static LineSubscribeQueryInfoVO convertoLineSubscribeQueryInfoVO(LineSubscribeQueryInfoDTO lineSubscribeQueryInfoDTO){
        LineSubscribeQueryInfoVO lineSubscribeQueryInfoVO = new LineSubscribeQueryInfoVO();
        lineSubscribeQueryInfoVO.setId(lineSubscribeQueryInfoDTO.getId());
        lineSubscribeQueryInfoVO.setDepartureAreaCode(lineSubscribeQueryInfoDTO.getDepartureAreaCode());
        lineSubscribeQueryInfoVO.setArriveAreaCode(lineSubscribeQueryInfoDTO.getArriveAreaCode());
        if(CollectionUtil.isNotEmpty(lineSubscribeQueryInfoDTO.getCartTypeList())){
            lineSubscribeQueryInfoVO.setCartTypeList(lineSubscribeQueryInfoDTO.getCartTypeList().stream().map(String::valueOf).collect(Collectors.toList()));
        }
        lineSubscribeQueryInfoVO.setArriveName(lineSubscribeQueryInfoDTO.getArriveName());
        lineSubscribeQueryInfoVO.setDepartureName(lineSubscribeQueryInfoDTO.getDepartureName());
        if(CollectionUtil.isNotEmpty(lineSubscribeQueryInfoDTO.getCartTypeNameList())){
            lineSubscribeQueryInfoVO.setCartTypeName(String.join("", lineSubscribeQueryInfoDTO.getCartTypeNameList()));
        }
        return lineSubscribeQueryInfoVO;
    }
}
