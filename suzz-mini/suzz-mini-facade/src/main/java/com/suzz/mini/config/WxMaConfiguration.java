package com.suzz.mini.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.suzz.mini.constant.SysConfigEnum;
import com.suzz.mini.serivce.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class WxMaConfiguration {

    @Autowired
    private SysConfigService sysConfigService;

    @Bean
    public WxMaService wxMaService() {
        String miniAppId = sysConfigService.getValue(SysConfigEnum.MINI_APP_ID.getKey());
        String miniAppSecret = sysConfigService.getValue(SysConfigEnum.MINI_APP_SECRET.getKey());
        WxMaService maService = new WxMaServiceImpl();
        Map<String, WxMaConfig> configs=new HashMap<>();
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(miniAppId);
        config.setSecret(miniAppSecret);
        configs.put(miniAppId,config);
        maService.setMultiConfigs(configs);
        return maService;
    }
}
