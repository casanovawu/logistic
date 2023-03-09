package com.suzz.platform.exception;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Collection;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/4/23 0:16
 **/
public class ProgramException extends ApplicationException{

    public ProgramException(String msg, String code) {
        super(msg, code);
    }

    public ProgramException(String msg) {
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

    public static <T> T checkNotNull(T reference, String message) throws ProgramException {
        assertTrue(Objects.nonNull(reference), message, (String)null);
        return reference;
    }

    public static <T> T checkNotNull(T reference, String message, String code) throws ProgramException {
        assertTrue(Objects.nonNull(reference), message, code);
        return reference;
    }

    public static void assertTrue(boolean result, String message) throws ProgramException {
        assertTrue(result, message, (String)null);
    }


    public static void assertTrue(boolean result, String message, String code) throws ProgramException {
        assertFalse(!result, message, code);
    }

    public static void assertFalse(boolean result, String message) throws ProgramException {
        assertFalse(result, message, (String)null);
    }


    public static void assertFalse(boolean result, String message, String code) throws ProgramException {
        if (result) {
            if (Objects.isNull(message)) {
                message = "参数为空";
            }

            if (Objects.isNull(code)) {
                code = "600";
            }

            throwProgramException(message, code);
        }

    }

    public static void assertEmpty(Collection<?> data, String message) throws ProgramException {
        assertEmpty(data, message, (String)null);
    }


    public static void assertEmpty(Collection<?> data, String message, String code) throws ProgramException {
        assertTrue(CollUtil.isEmpty(data), message, code);
    }

    public static void assertNotEmpty(Collection<?> data, String message) throws ProgramException {
        assertNotEmpty((Collection)data, message, (String)null);
    }


    public static void assertNotEmpty(Collection<?> data, String message, String code) throws ProgramException {
        assertTrue(CollUtil.isNotEmpty(data), message, code);
    }

    public static void assertNotEmpty(String data, String message) throws ProgramException {
        assertTrue(StrUtil.isNotEmpty(data), message);
    }


    public static void assertNotEmpty(String data, String message, String code) throws ProgramException {
        assertTrue(StrUtil.isNotEmpty(data), message, code);
    }

    public static void assertNotBlank(String data, String message) throws ProgramException {
        assertTrue(StrUtil.isNotBlank(data), message);
    }

    public static void assertNotBlank(String data, String message, String code) throws ProgramException {
        assertTrue(StrUtil.isNotBlank(data), message, code);
    }

    public static ProgramException of(String message, String code) {
        return new ProgramException(message, code);
    }

    public static void throwProgramException(String message, String code) {
        throw of(message, code);
    }
}
