package com.suzz.mini.domain;


import com.suzz.mini.dto.MiniUserAuthInfoDTO;
import com.suzz.mini.dto.MiniUserAuthReqDTO;
import com.suzz.mini.dto.MiniUserDetailInfoDTO;
import com.suzz.mini.dto.MiniUserUpdateReqDTO;
import lombok.Data;

import java.util.Objects;

/**
 * mini_user
 * @author 
 */
@Data
public class MiniUser  {

    private Integer id;

    /**
     * 0.男 1.女
     */
    private Boolean sex;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * openId
     */
    private String openId;

    /**
     * unionId
     */
    private String unionId;

    /**
     * 语言
     */
    private String language;

    /**
     * 个人介绍
     */
    private String introduce;

    /**
     * 头像
     */
    private String headPic;

    /**
     * 1.司机 2货主
     */
    private Integer type;

    public static MiniUser toMiniUserByAuth(MiniUserAuthReqDTO userAuthReqDTO){
        MiniUser miniUser = new MiniUser();
        if(Objects.nonNull(userAuthReqDTO) && Objects.nonNull(userAuthReqDTO.getSex())){
            miniUser.setSex(userAuthReqDTO.getSex()==1);
        }
        miniUser.setUserName(userAuthReqDTO.getUserName());
        miniUser.setOpenId(userAuthReqDTO.getOpenId());
        miniUser.setUnionId(userAuthReqDTO.getUnion_id());
        miniUser.setLanguage(userAuthReqDTO.getLanguage());
        miniUser.setHeadPic(userAuthReqDTO.getHeadPic());
        miniUser.setType(userAuthReqDTO.getType());
        return miniUser;
    }

    public MiniUserAuthInfoDTO toMiniUseInfoDTO(){
        MiniUserAuthInfoDTO miniUserAuthInfoDTO =new MiniUserAuthInfoDTO();
        miniUserAuthInfoDTO.setMiniUserId(this.id);
        miniUserAuthInfoDTO.setLanguage(this.language);
        miniUserAuthInfoDTO.setType(this.type);
        return miniUserAuthInfoDTO;
    }

    public MiniUserDetailInfoDTO toMiniUserDetailInfoDTO(){
        MiniUserDetailInfoDTO miniUserDetailInfoDTO=new MiniUserDetailInfoDTO();
        miniUserDetailInfoDTO.setMiniUserId(this.id);
        miniUserDetailInfoDTO.setLanguage(this.language);
        miniUserDetailInfoDTO.setType(this.type);
        miniUserDetailInfoDTO.setHeadUrl(this.headPic);
        miniUserDetailInfoDTO.setName(this.userName);
        miniUserDetailInfoDTO.setPhone(this.phone);
        return miniUserDetailInfoDTO;
    }

    public static MiniUser toMiniUserByUpdate(MiniUserUpdateReqDTO miniUserUpdateReqDTO){
        MiniUser miniUser = new MiniUser();
        miniUser.setId(miniUserUpdateReqDTO.getMiniUserId());
        miniUser.setPhone(miniUserUpdateReqDTO.getPhone());
        miniUser.setLanguage(miniUserUpdateReqDTO.getLanguage());
        miniUser.setType(miniUserUpdateReqDTO.getType());
        return miniUser;

    }
}