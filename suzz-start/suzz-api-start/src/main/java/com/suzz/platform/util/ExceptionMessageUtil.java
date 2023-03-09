package com.suzz.platform.util;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.suzz.platform.constant.MDCParaEnum;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import org.slf4j.MDC;

import java.util.Objects;

/**
 * 异常信息处理类
 */
public class ExceptionMessageUtil {

    private final static int exceptionLimitNum = 1000;

    /**
     * 获取异常简述
     */
    public static String obtainExceptionMessage(Exception e){
        if(Objects.isNull(e)){
            return null;
        }
        if(e instanceof ApplicationException){
            ApplicationException applicationException = (ApplicationException)e;
            return applicationException.getErrorMsg();
        } else {
            return e.getMessage();
        }
    }

    /**
     * 获取异常简述
     */
    public static String obtainExceptionCode(Exception e){
        if(Objects.isNull(e)){
            return null;
        }
        if(e instanceof ApplicationException){
            ApplicationException applicationException = (ApplicationException)e;
            return applicationException.getErrCode();
        } else {
            return "error";
        }
    }

    /**
     * 原有的异常信息拼接新的异常
     */
    public static String appendNewException(String newDesc, Exception e){
        String oldExceptionMsg = MDC.get(MDCParaEnum.EXCEPTION_MESSAGE.getName());
        StringBuilder sb = new StringBuilder();
        sb.append(Objects.isNull(oldExceptionMsg) ? "" : oldExceptionMsg);
        if(Objects.nonNull(e)){
            if(sb.length() > 0){
                sb.append(System.getProperty("line.separator"));
            }
            if(Objects.nonNull(newDesc)){
                sb.append(newDesc);
            }
            sb.append(ExceptionUtil.stacktraceToOneLineString(e, exceptionLimitNum)).
                    append(System.getProperty("line.separator"));
        } else {
            sb.append(newDesc).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    /**
     * 原有的异常信息拼接新的异常
     */
    public static String appendNewException(Exception e){
        return appendNewException(null, e);
    }

    /**
     * 原有的异常信息拼接新的异常
     */
    public static String appendNewException(String newDesc){
        return appendNewException(newDesc, null);
    }

}
