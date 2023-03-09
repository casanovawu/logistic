package com.suzz.mini.convertor;

import com.suzz.mini.constant.LangEnum;
import com.suzz.mini.constant.MiniUserTypeEnum;
import com.suzz.mini.dto.*;
import com.suzz.mini.vo.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/5/15 18:48
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MiniUserConvertor {

    public static MiniUserSessionVO convertorToMiniUserSessionVO(MiniUserSessionDTO miniUserSessionDTO){
        MiniUserSessionVO miniUserSessionVO = new MiniUserSessionVO();
        miniUserSessionVO.setOpenId(miniUserSessionDTO.getOpenId());
        miniUserSessionVO.setUnionId(miniUserSessionDTO.getUnionId());
        miniUserSessionVO.setSessionKey(miniUserSessionDTO.getSessionKey());
        return miniUserSessionVO;
    }

    public static MiniUseAuthInfoVO convertorToMiniUseInfoVO(MiniUserAuthInfoDTO miniUserAuthInfoDTO){
        MiniUseAuthInfoVO miniUseAuthInfoVO = new MiniUseAuthInfoVO();
        miniUseAuthInfoVO.setMiniUserId(miniUserAuthInfoDTO.getMiniUserId());
        miniUseAuthInfoVO.setLanguage(miniUserAuthInfoDTO.getLanguage());
        miniUseAuthInfoVO.setType(miniUserAuthInfoDTO.getType());
        return miniUseAuthInfoVO;
    }

    public static MiniUserDetailInfoVO convertorToMiniUserDetailInfoVO(MiniUserDetailInfoDTO miniUserDetailInfoDTO){
        MiniUserDetailInfoVO miniUserDetailInfoVO = new MiniUserDetailInfoVO();
        miniUserDetailInfoVO.setMiniUserId(miniUserDetailInfoDTO.getMiniUserId());
        miniUserDetailInfoVO.setLanguage(miniUserDetailInfoDTO.getLanguage());
        if(LangEnum.CHINESE.getCode().equals(miniUserDetailInfoDTO.getLanguage())){
            miniUserDetailInfoVO.setLanguageName(LangEnum.CHINESE.getName());
        }
        if(LangEnum.ENGLISH.getCode().equals(miniUserDetailInfoDTO.getLanguage())){
            miniUserDetailInfoVO.setLanguageName(LangEnum.ENGLISH.getName());
        }
        miniUserDetailInfoVO.setType(miniUserDetailInfoDTO.getType());
        miniUserDetailInfoVO.setTypeName(MiniUserTypeEnum.valueOf(miniUserDetailInfoDTO.getType()).getName());
        miniUserDetailInfoVO.setName(miniUserDetailInfoDTO.getName());
        if(miniUserDetailInfoDTO.getHeadUrl().startsWith("http")){
            miniUserDetailInfoVO.setHeadUrl(miniUserDetailInfoDTO.getHeadUrl());
        }else{
            miniUserDetailInfoVO.setHeadUrl("http://1.116.142.225:8092/mini/web/picture/queryHead?path="+miniUserDetailInfoDTO.getHeadUrl());
        }
        miniUserDetailInfoVO.setPhone(miniUserDetailInfoDTO.getPhone());
        return miniUserDetailInfoVO;
    }

    public static MiniUserAuthReqDTO convertorToMiniUserAuthReqDTO(MiniUserAuthReqVO miniUserAuthReqVO){
        MiniUserAuthReqDTO miniUserAuthReqDTO = new MiniUserAuthReqDTO();
        miniUserAuthReqDTO.setOpenId(miniUserAuthReqVO.getOpenId());
        miniUserAuthReqDTO.setUserName(miniUserAuthReqVO.getUserName());
        miniUserAuthReqDTO.setUnion_id(miniUserAuthReqVO.getUnion_id());
        miniUserAuthReqDTO.setLanguage(miniUserAuthReqVO.getLanguage());
        miniUserAuthReqDTO.setHeadPic(miniUserAuthReqVO.getHeadPic());
        miniUserAuthReqDTO.setSex(miniUserAuthReqVO.getSex());
        miniUserAuthReqDTO.setType(miniUserAuthReqVO.getType());
        return miniUserAuthReqDTO;
    }

    public static MiniUserDetailReqDTO convertorToMiniUserDetailReqDTO(MiniUserDetailReqVO miniUserDetailReqVO){
        MiniUserDetailReqDTO miniUserDetailReqDTO = new MiniUserDetailReqDTO();
        miniUserDetailReqDTO.setMiniUserId(miniUserDetailReqVO.getMiniUserId());
        return miniUserDetailReqDTO;
    }

    public static MiniUserUpdateReqDTO convertorToMiniUserUpdateReqDTO(MiniUserUpdateReqVO miniUserUpdateReqVO){
        MiniUserUpdateReqDTO miniUserUpdateReqDTO = new MiniUserUpdateReqDTO();
        miniUserUpdateReqDTO.setMiniUserId(miniUserUpdateReqVO.getMiniUserId());
        miniUserUpdateReqDTO.setLanguage(miniUserUpdateReqVO.getLanguage());
        miniUserUpdateReqDTO.setType(miniUserUpdateReqVO.getType());
        miniUserUpdateReqDTO.setPhone(miniUserUpdateReqVO.getPhone());
        return miniUserUpdateReqDTO;
    }
}
