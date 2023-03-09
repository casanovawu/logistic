package com.suzz.platform.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum YesNoTypeEnum {
	
	SELECT_YES(1,"是"),
	SELECT_NO(0,"否");

	private Integer code;

	private String value;
}
