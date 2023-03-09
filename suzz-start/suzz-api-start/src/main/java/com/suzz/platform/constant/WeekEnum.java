package com.suzz.platform.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public enum WeekEnum{

	MON("Mon", "周一"),
	TUE("Tue", "周二"),
	WED("Wed", "周三"),
	THU("Thu", "周四"),
	FRI("Fri", "周五"),
	SAT("Sat", "周六"),
	SUN("Sun", "周日");

	private String code;

	private String message;
}
