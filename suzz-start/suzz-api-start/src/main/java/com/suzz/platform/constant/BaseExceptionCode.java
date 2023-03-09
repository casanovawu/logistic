package com.suzz.platform.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access= AccessLevel.PRIVATE)
public enum BaseExceptionCode {
	
	SUCCESS(0,"操作成功"),
	FAILURE(0,"操作失败"),
	UNKNOWN_ERROR(-1,"未知错误"),
	SYSTEM_ERROR(-100,"系统级错误"),
	INVALID_REQUEST(1001,"非法参数"),
	FAIL_TO_VALIDATE(1002,"参数验证失败"),
	DATA_ACCESS_EXCEPTION(1003,"数据库异常"),
	VAILDATOR_SETTING_ERROR(1004,"校验规则错误"),
	NO_AUTHORIZATION(1011,"没有登陆,请重新登陆!"),
	ARGS_VALIDATE_ERROR(1012,  "参数校验失败"),
	NO_WIDE_ACCESS(1013,"禁止访问!");

	private Integer code;

	private String message;
}
