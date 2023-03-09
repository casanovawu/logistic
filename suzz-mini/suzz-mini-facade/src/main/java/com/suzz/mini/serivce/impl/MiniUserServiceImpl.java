package com.suzz.mini.serivce.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.suzz.mini.domain.MiniUser;
import com.suzz.mini.domain.MiniUserSession;
import com.suzz.mini.mapper.MiniUserMapper;
import com.suzz.mini.serivce.MiniUserService;
import com.suzz.platform.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author subo
 * @date 2022/5/2 15:09
 **/
@Service
@Slf4j
public class MiniUserServiceImpl implements MiniUserService {

    @Autowired
    private MiniUserMapper miniUserMapper;

    @Autowired
    private WxMaService wxMaService;

    @Override
    public MiniUserSession getSession(String code) {
        try {
            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.jsCode2SessionInfo(code);
            return MiniUserSession.toMiniUserSession(wxMaJscode2SessionResult);
        }catch (Exception e){
            throw new ApplicationException(e.getMessage(),"-1");
        }
    }

    @Override
    public boolean checkExist(String openId) {
        MiniUser miniUser = miniUserMapper.selectByOpenId(openId);
        return Objects.nonNull(miniUser);
    }

    @Override
    public void createMiniUser(MiniUser miniUser) {
        miniUserMapper.insertSelective(miniUser);
    }

    @Override
    public void updateMiniUser(MiniUser miniUser) {
        miniUserMapper.updateByPrimaryKeySelective(miniUser);
    }

    @Override
    public MiniUser auth(MiniUser miniUser) {
        MiniUser miniUserExist = miniUserMapper.selectByOpenId(miniUser.getOpenId());
        if(Objects.nonNull(miniUserExist)){
            miniUserMapper.updateByPrimaryKeySelective(miniUser);
            return miniUserMapper.selectByPrimaryKey(miniUserExist.getId());
        }else {
            miniUserMapper.insertSelective(miniUser);
            return miniUserMapper.selectByPrimaryKey(miniUser.getId());
        }
    }

    @Override
    public MiniUser selectByPrimaryKey(Integer id) {
        return miniUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public MiniUser update(MiniUser miniUser) {
        updateMiniUser(miniUser);
        return miniUserMapper.selectByPrimaryKey(miniUser.getId());
    }
}
