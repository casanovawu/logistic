package com.suzz.mini.utils;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * 通用http请求
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpCommonUtil {

    private static final Integer CONNECTION_TIME_OUT = 60000;

    private static final Integer READ_TIME_OUT = 60000;

    /**
     * 根据url 发起get请求
     * @param url 请求地址
     * @return 请求结果
     */
    public static String executeGet(String url){
        HttpRequest getRequest =  HttpUtil.createGet(url).setReadTimeout(READ_TIME_OUT)
                .setConnectionTimeout(CONNECTION_TIME_OUT);
        HttpResponse resp = getRequest.execute();
        log.debug("应答状态码：" + resp.getStatus());
        return resp.body();
    }

    /**
     * 根据url 发起get请求
     * @param url 请求地址
     * @return 请求结果
     */
    public static <T> String executePost(String url, T t){
        HttpRequest postRequest =  HttpUtil.createPost(url).setReadTimeout(READ_TIME_OUT)
                .setConnectionTimeout(CONNECTION_TIME_OUT);
        postRequest.contentType(ContentType.JSON.getValue());
        String json = JSON.toJSONString(t);
        System.out.println(json);
        postRequest.body(json, ContentType.JSON.getValue());
        HttpResponse resp = postRequest.execute();
        log.debug("应答状态码：" + resp.getStatus());
        return resp.body();
    }

}
