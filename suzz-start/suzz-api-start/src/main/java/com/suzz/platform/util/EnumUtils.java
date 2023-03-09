package com.suzz.platform.util;

import com.suzz.platform.constant.BaseEnum;

import java.util.Objects;

/**
 * 配合BaseEnum使用
 *
 */
public class EnumUtils {

	public static <T extends BaseEnum<?>> String getNameById(Class<T> type, Integer id) {
		T data = valueOf(type,id);
		if(Objects.nonNull(data)) {
			return data.getName();
		}else {
			return "";
		}
	}
	
	public static <T extends BaseEnum<?>> String getNameById(Class<T> type,int id) {
		T data = valueOf(type,id);
		if(Objects.nonNull(data)) {
			return data.getName();
		}else {
			return "";
		}
	}

	public static <T extends BaseEnum<?>> T valueOf(Class<T> type,Integer code) {
		if(Objects.nonNull(code)) {
			return valueOf(type, code.intValue());
		}else {
			return null;
		}
	}
	
	public static <T extends BaseEnum<?>> T getEnumByCode(Class<T> type,String code) {
		if(Objects.nonNull(code)) {
			try {
				Integer t = Integer.valueOf(code);
				return valueOf(type, t.intValue());
			} catch (Exception e) {
				return null;
			}
		}else {
			return null;
		}
	}
	
	public static <T extends BaseEnum<?>> T valueOf(Class<T> type,int code) {
		T[] enumConstants = type.getEnumConstants();
		for (T baseEnum : enumConstants) {
			if(baseEnum.getCode().intValue()==code) {
				return baseEnum;
			}
		}
		return null;
	}
	
	public static <T extends BaseEnum<?>> T getEnumByCode(Class<T> type,int code) {
		T[] enumConstants = type.getEnumConstants();
		for (T baseEnum : enumConstants) {
			if(baseEnum instanceof BaseEnum<?>) {
				if(baseEnum.getCode().intValue()==code) {
					return baseEnum;
				}
			}
		}
		return null;
	}
	
	public static <T extends BaseEnum<?>> T getEnumByCode(Class<T> type,Integer code) {
		if(Objects.nonNull(code)) {
			return getEnumByCode(type, code.intValue());
		}else {
			return null;
		}
	}
	
	/** 获取枚举类型的code */
	public static <T extends BaseEnum<?>> Integer getEnumCode(T enumType) {
		if(Objects.isNull(enumType)) {
			return null;
		}else {
			return enumType.getCode();
		}
	}
	
	public static <T extends BaseEnum<?>> String getEnumName(T enumType) {
		if(Objects.isNull(enumType)) {
			return null;
		}else {
			return enumType.getName();
		}
	}
}
