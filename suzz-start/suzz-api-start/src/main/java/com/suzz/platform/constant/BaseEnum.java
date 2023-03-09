package com.suzz.platform.constant;

/**
 * 用于定义基础枚举类型，mybatis可以自动将枚举值和枚举映射，
 * <br>
 * 所有实现类需要独立实现方法
 * <br>
 * public static <T> T valueOf(Integer code) {<br>
 *     return EnumUtil.getEnumByCode(<T>.class, code);<br>
 * }
 *
 *
 * @param <E>
 * @param <T>
 */
public interface BaseEnum<E extends Enum<E>> {

	/**
	 * 枚举的值
	 * @return
	 */
	public Integer getCode();

	/**
	 * 枚举值对应的中文
	 * @return
	 */
	public String getName();
	
	
	
}