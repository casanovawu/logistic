package com.suzz.platform;

import com.suzz.platform.constant.BaseExceptionCode;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.util.StringsUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author subo
 * @date 2019/10/30 1:12
 **/
@RestControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("UNEXCEPTEXCEPTION");

    private Logger loggerAppException = LoggerFactory.getLogger("ApplicationException");

    @ExceptionHandler(value = Exception.class)
    public Object handleApplicationException(HttpServletResponse response, Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            ResponseDTO dto = new ResponseDTO();
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) exception;
            StringBuilder errMsg = new StringBuilder();
            for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
                try {
                    String errorMessage = error.getDefaultMessage();
                    errMsg.append(errorMessage);
                    errMsg.append(";");
                } catch (Exception e) {
                    String errorMsg = BaseExceptionCode.VAILDATOR_SETTING_ERROR.getMessage();
                    errMsg.append(error.getField()).append(errorMsg);
                    errMsg.append(";");
                }
            }

            dto.systemFail(StringsUtil.valueOf(BaseExceptionCode.UNKNOWN_ERROR.getCode()),
                    BaseExceptionCode.FAILURE.getMessage(),
                    errMsg.toString());
            return dto;

        } else if (exception instanceof ApplicationException) {
            ResponseDTO dto = new ResponseDTO();
            ApplicationException appExp = (ApplicationException) exception;
            dto.systemFail(StringsUtil.valueOf(appExp.getErrCode()),
                    BaseExceptionCode.FAILURE.getMessage(),
                    appExp.getErrorMsg());
            loggerAppException.error(appExp.getMessage(), appExp);
            return dto;
        }  else {
            ResponseDTO dto = new ResponseDTO();
            dto.systemFail(StringsUtil.valueOf(BaseExceptionCode.UNKNOWN_ERROR.getCode()),
                    BaseExceptionCode.FAILURE.getMessage(),
                    BaseExceptionCode.FAILURE.getMessage());
            logger.error(exception.getMessage(), exception);
            return dto;
        }
    }

}
