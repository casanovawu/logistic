package com.suzz.platform.exception;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Collection;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/4/22 23:57
 **/
public class BusinessException extends ApplicationException{

    public BusinessException(String msg, String code) {
        super(msg, code);
    }

    public BusinessException(String msg) {
        super(msg, "-1");
    }

    public static void assertNull(Object o, String message) {
        assertTrue(Objects.isNull(o), message);
    }


    public static void assertNull(Object o, String message, String code) {
        assertTrue(Objects.isNull(o), message, code);
    }

    public static void assertNotNull(Object o, String message) {
        assertTrue(Objects.nonNull(o), message);
    }

    public static void assertNotNull(Object o, String message, String code) {
        assertTrue(Objects.nonNull(o), message, code);
    }

    public static <T> T checkNotNull(T reference, String message) throws BusinessException {
        assertTrue(Objects.nonNull(reference), message, (String)null);
        return reference;
    }

    public static <T> T checkNotNull(T reference, String message, String code) throws BusinessException {
        assertTrue(Objects.nonNull(reference), message, code);
        return reference;
    }

    public static void assertTrue(boolean result, String message) throws BusinessException {
        assertTrue(result, message, (String)null);
    }

    public static void assertTrue(boolean result, String message, String code) throws BusinessException {
        assertFalse(!result, message, code);
    }

    public static void assertFalse(boolean result, String message) throws BusinessException {
        assertFalse(result, message, (String)null);
    }

    public static void assertFalse(boolean result, String message, String code) throws BusinessException {
        if (result) {
            if (Objects.isNull(message)) {
                message = "参数为空";
            }

            if (Objects.isNull(code)) {
                code = "500";
            }

            throwBusinessException(message, code);
        }

    }

    public static void assertEmpty(Collection<?> data, String message) throws BusinessException {
        assertTrue(CollUtil.isEmpty(data), message, (String)null);
    }


    public static void assertEmpty(Collection<?> data, String message, String code) throws BusinessException {
        assertTrue(CollUtil.isEmpty(data), message, code);
    }

    public static void assertNotEmpty(Collection<?> data, String message) throws BusinessException {
        assertTrue(CollUtil.isNotEmpty(data), message, (String)null);
    }


    public static void assertNotEmpty(Collection<?> data, String message, String code) throws BusinessException {
        assertTrue(CollUtil.isNotEmpty(data), message, code);
    }

    public static void assertNotEmpty(String data, String message) throws BusinessException {
        assertTrue(StrUtil.isNotEmpty(data), message);
    }


    public static void assertNotEmpty(String data, String message, String code) throws BusinessException {
        assertTrue(StrUtil.isNotEmpty(data), message, code);
    }

    public static void assertNotBlank(String data, String message) throws BusinessException {
        assertTrue(StrUtil.isNotBlank(data), message);
    }

    public static void assertNotBlank(String data, String message, String code) throws BusinessException {
        assertTrue(StrUtil.isNotBlank(data), message, code);
    }

    public static BusinessException of(String message, String code) {
        return new BusinessException(message, code);
    }

    public static void throwBusinessException(String message, String code) {
        throw of(message, code);
    }
}
