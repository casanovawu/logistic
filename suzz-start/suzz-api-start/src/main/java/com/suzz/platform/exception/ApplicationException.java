package com.suzz.platform.exception;


import java.util.Objects;

/**
 * @author subo
 * @date 2022/4/23 0:02
 **/
public class ApplicationException extends RuntimeException{

    private static final long serialVersionUID = -2511096462565246606L;
    private String errorMsg;
    private String errCode;
    private Object[] args;

    public ApplicationException(String errorMsg, String errorCode) {
        super(errorMsg);
        this.errCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ApplicationException(String errorMsg, String errorCode, Object... args) {
        super(errorMsg);
        this.errCode = errorCode;
        this.errorMsg = errorMsg;
        this.args = args;
    }

    public String getMessage() {
        return Objects.nonNull(this.errorMsg) ? "[" + this.errCode + "]" + this.errorMsg : super.getMessage();
    }

    public String getLocalizedMessage() {
        return Objects.nonNull(this.errorMsg) ? "[" + this.errCode + "]" + this.errorMsg : super.getLocalizedMessage();
    }

    public static ApplicationException of(String errorMsg, String errorCode) {
        return new ApplicationException(errorMsg, errorCode);
    }

    public ApplicationException() {
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public Object[] getArgs() {
        return this.args;
    }
}
