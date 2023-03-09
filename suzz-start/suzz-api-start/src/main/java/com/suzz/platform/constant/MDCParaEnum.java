package com.suzz.platform.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MDCParaEnum {

    SERVLET_PATH("Servlet_Path", "请求地址"),
    TRACE_ID("Trace_Id", "trace id"),
    METHOD("Method", "调用方法"),
    EXCEPTION_MESSAGE("Exception_Message", "异常简述"),
    REQUEST_PARA("request_para", "请求参数"),
    RESPONSE_RESULT("response_result", "返回结果"),
    EXECUTE_TIME("execution_time", "执行时间"),
    EXCEPTION_DETAIL("Exception_Detail", "异常明细"),
    EXCEPTION_CODE("Exception_Code", "异常代码"),
    IP("IP", "客户端ip"),
    OPERATOR_ID("OperatorId", "操作人Id"),
    MEMBER_ID("MemberId", "会员"),
    WRITE_OFF_ID("WriteOffId", "核销人Id"),
    ;

    private final String name;

    private final String desc;

}
