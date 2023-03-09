package com.suzz.mini.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/4 13:52
 **/
public interface LineSubscribeEnum {

    @Getter
    @AllArgsConstructor
    public enum LineSubscribeSendEnum {

        UNSEND(0,"未发送"),
        SENDED(1,"已发送");

        private Integer code;
        private String value;
    }
    @Getter
    @AllArgsConstructor
    public enum LineSubscribeTemplateEnum {

        MESSAGE("ntoik2DZhkXh-WlEYFEcWS6ejpYbQWocXelj09fCFuA","订阅消息"),
        LONG_MESSAGE("LrMZNampNb4Hx-NsqCTnXM8tUEk8-kLN1G0OutfHbvw","订阅消息");


        private String code;
        private String value;
    }

}
