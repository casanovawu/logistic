package com.suzz.platform.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnumUtil extends cn.hutool.core.util.EnumUtil {

    private final static String DEFAULT_FIELD = "code";

    /**
     * 根据给定枚举值 获取对应的枚举
     *
     * @param <E>       枚举类型
     * @param enumClass 枚举类
     * @param value     值
     * @return 匹配到的枚举对象，未匹配到返回null
     */
    public static <E extends Enum<E>, P> E valueOfDefaultField(Class<E> enumClass, P value) {
        if(Objects.isNull(value)){
            return null;
        }
        return valueOf(enumClass, value, DEFAULT_FIELD);
    }

    /**
     * 根据给定枚举值 获取对应的枚举
     *
     * @param <E>       枚举类型
     * @param enumClass 枚举类
     * @param value     值
     * @param field     字段名称
     * @return 匹配到的枚举对象，未匹配到返回null
     */
    public static <E extends Enum<E>, P> E valueOf(Class<E> enumClass, P value, String field) {
        if(Objects.isNull(value)){
            return null;
        }
        final E[] enums = enumClass.getEnumConstants();
        for (E enumObj : enums) {
            if (ObjectUtil.equal(value, ReflectUtil.getFieldValue(enumObj, field))) {
                return enumObj;
            }
        }
        return null;
    }

    /**
     * 根据给定枚举值 获取对应的枚举
     *
     * @param <E>       枚举类型
     * @param enumClass 枚举类
     * @param value     值
     * @return 匹配到的枚举对象，未匹配到返回null
     */
    public static <E extends Enum<E>, P> List<E> valueOfBinary(Class<E> enumClass, P value) {
        if(Objects.isNull(value)){
            return null;
        }
        return valueOfBinary(enumClass, value, DEFAULT_FIELD);
    }

    /**
     * 根据给定枚举值 获取对应的枚举
     *
     * @param <E>       枚举类型
     * @param enumClass 枚举类
     * @param value     值
     * @param field     字段名称
     * @return 匹配到的枚举对象，未匹配到返回null
     */
    public static <E extends Enum<E>, P> List<E> valueOfBinary(Class<E> enumClass, P value, String field) {
        if(Objects.isNull(value)){
            return new ArrayList<>();
        }
        List<E> es = new ArrayList<>();
        final E[] enums = enumClass.getEnumConstants();
        for (E enumObj : enums) {
            Object res = ReflectUtil.getFieldValue(enumObj, field);
            if (ObjectUtil.equal(value, res)) {
                es.add(enumObj);
                break;
            } else {
                if(value instanceof Integer) {
                    Integer compareFrom = Convert.toInt(value);
                    Integer compareTo = Convert.toInt(res);
                    if(Objects.nonNull(compareTo) && Objects.nonNull(compareFrom) &&
                            ((compareFrom & compareTo) > 0)){
                        es.add(enumObj);
                    }
                }
            }
        }
        return es;
    }

    /**
     * 对传入的枚举集合的code值进行求和
     *
     * @param enumList 枚举集合
     * @param <E> 枚举类型
     * @return 枚举集合code之和
     */
    public static <E extends Enum<E>> Integer enumListSumCode (List<E> enumList){
        Integer temp = null;
        for (E e : enumList) {
            Object obj = ReflectUtil.getFieldValue(e, DEFAULT_FIELD);
            if(obj instanceof Integer){
                temp = Objects.isNull(temp)? 0: temp;
                temp += (Integer)obj;
            }
        }
        return temp;
    }




}
