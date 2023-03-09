package com.suzz.mini.domain;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.suzz.mini.dto.MiniUserSessionDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/2 15:07
 **/
@Data
public class MiniUserSession {

    /**
     * 用户openId
     */
    private String openId;

    /**
     * 用户unionId
     */
    private String unionId;

    /**
     * 用户sessionKey
     */
    private String sessionKey;


    public static MiniUserSession toMiniUserSession(WxMaJscode2SessionResult wxMaJscode2SessionResult) {
        MiniUserSession miniUserSession = new MiniUserSession();
        miniUserSession.setOpenId(wxMaJscode2SessionResult.getOpenid());
        miniUserSession.setUnionId(wxMaJscode2SessionResult.getUnionid());
        miniUserSession.setSessionKey(wxMaJscode2SessionResult.getSessionKey());
        return miniUserSession;
    }

    public MiniUserSessionDTO toMiniUserSessionDTO(){
        MiniUserSessionDTO miniUserSessionDTO=new MiniUserSessionDTO();
        miniUserSessionDTO.setOpenId(this.openId);
        miniUserSessionDTO.setUnionId(this.unionId);
        miniUserSessionDTO.setSessionKey(this.sessionKey);
        return miniUserSessionDTO;
    }
}
