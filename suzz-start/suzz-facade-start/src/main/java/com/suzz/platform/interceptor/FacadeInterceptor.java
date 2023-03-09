package com.suzz.platform.interceptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.suzz.platform.annotation.LogOperation;
import com.suzz.platform.constant.LogTypeEnum;
import com.suzz.platform.constant.MDCParaEnum;
import com.suzz.platform.constant.ResponseCodeEnum;
import com.suzz.platform.domain.log.LogRecord;
import com.suzz.platform.dto.RequestDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.service.OperationLogService;
import com.suzz.platform.util.*;
import com.suzz.platform.vo.request.CommandRequest;
import com.suzz.platform.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Slf4j
@Aspect
@Component
@Order(9)
public class FacadeInterceptor{

    @Pointcut("execution(public * com.suzz..*.facade.impl..*(..))")
    public void aspect(){}

    @Around("aspect()")
    public Object aroundFacade(ProceedingJoinPoint pjp) throws Throwable{
		addTraceToRpcAttachment();
		Method targetMethod = ((MethodSignature)(pjp.getSignature())).getMethod();
		String methodName = pjp.getTarget().getClass().getSimpleName() + "." + targetMethod.getName();
		try {
			RequestDTO request = getRequestDTO(pjp);
			//recordRequest(request, methodName);
			setCommand(request);
			Object o = pjp.proceed();
			long startTime = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;
			operateLog(pjp);
			recordResult(o, methodName);
			if (o instanceof ResponseDTO) {
				ResponseDTO response = (ResponseDTO) o;
				response.setTraceId(MDC.get(MDCParaEnum.TRACE_ID.getName()));
				response.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
				//MDC.put(MDCParaEnum.EXECUTE_TIME.getName(), StringsUtil.valueOf(executionTime));
			}
			return o;
		} catch (ApplicationException e) {
			recordException(e, methodName);
			throw e;
		} catch (ValidationException e) {
			recordException(e, methodName);
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			recordException(e, methodName);
			throw new ProgramException("系统错误，请联系管理员");
		} finally {
			threadClear();
			removeTraceFromRpcAttachment();
		}
    }


	/**
	 * 记录请求参数
	 */
	private void recordRequest(RequestDTO request, String methodName) {
		String requestStr = Objects.isNull(request) ? "无入参" : JSON.toJSONString(request);
		MDC.put(MDCParaEnum.METHOD.getName(), methodName);
		MDC.put(MDCParaEnum.REQUEST_PARA.getName(), requestStr);
	}

	/**
	 * 记录返回结果
	 */
	private void recordResult(Object obj, String methodName) {
		String resultStr = Objects.isNull(obj) ? "无结果" : JSON.toJSONString(obj);
		MDC.put(MDCParaEnum.METHOD.getName(), methodName);
		MDC.put(MDCParaEnum.RESPONSE_RESULT.getName(), resultStr);
	}

	/**
	 * 记录异常
	 */
	private void recordException(Exception e, String methodName) {
		log.info(e.getMessage(), e);
		MDC.put(MDCParaEnum.METHOD.getName(), methodName);
		String exceptionMessage;
		if(e instanceof ApplicationException){
			exceptionMessage = ExceptionMessageUtil.appendNewException(e);
		} else {
			exceptionMessage = ExceptionMessageUtil.appendNewException(e.getMessage(), e);
		}
		MDC.put(MDCParaEnum.EXCEPTION_MESSAGE.getName(), ExceptionMessageUtil.obtainExceptionMessage(e));
		MDC.put(MDCParaEnum.EXCEPTION_DETAIL.getName(), exceptionMessage);
		MDC.put(MDCParaEnum.EXCEPTION_CODE.getName(), ExceptionMessageUtil.obtainExceptionCode(e));
	}

	/**
	 * 添加 trace id 到rpc上下文
	 */
	private void addTraceToRpcAttachment(){
		String traceId = RpcContext.getContext().getAttachment(MDCParaEnum.TRACE_ID.getName());
		if (StrUtil.isBlank(traceId)) {
			traceId = RequestTraceIdUtil.create();
			RpcContext.getContext().setAttachment(MDCParaEnum.TRACE_ID.getName(), traceId);
		}
		MDC.put(MDCParaEnum.TRACE_ID.getName(), traceId);
	}

	/**
	 * 移除 trace id 到rpc上下文
	 */
	private void removeTraceFromRpcAttachment(){
		// 由调用放清理
		RpcContext.getContext().remove(MDCParaEnum.TRACE_ID.getName());
		MDC.remove(MDCParaEnum.TRACE_ID.getName());
		MDC.remove(MDCParaEnum.SERVLET_PATH.getName());
		MDC.remove(MDCParaEnum.METHOD.getName());
		MDC.remove(MDCParaEnum.EXCEPTION_MESSAGE.getName());
		MDC.remove(MDCParaEnum.REQUEST_PARA.getName());
		MDC.remove(MDCParaEnum.RESPONSE_RESULT.getName());
		MDC.remove(MDCParaEnum.EXECUTE_TIME.getName());
		MDC.remove(MDCParaEnum.EXCEPTION_DETAIL.getName());
		MDC.remove(MDCParaEnum.EXCEPTION_CODE.getName());
		MDC.remove(MDCParaEnum.IP.getName());
		MDC.remove(MDCParaEnum.OPERATOR_ID.getName());
		MDC.remove(MDCParaEnum.MEMBER_ID.getName());
		MDC.remove(MDCParaEnum.WRITE_OFF_ID.getName());
	}

	/**
	 * 操作日志
	 */
	private void operateLog(ProceedingJoinPoint pjp) {
		try {
			Method targetMethod = ((MethodSignature)(pjp.getSignature())).getMethod();
			LogOperation logOperation = targetMethod.getAnnotation(LogOperation.class);
			if(Objects.nonNull(logOperation) && LogOperationThreadLocal.hasLog()){
				Map<String, String> log = LogOperationThreadLocal.get();
				for(Map.Entry<String, String> entry : log.entrySet()){
					OperationLogService operationLogService = AppContext.getBean(OperationLogService.class);
					LogRecord logRecord = operationLogService.convert(entry.getKey());
					if(Objects.nonNull(logRecord)){
						logRecord.setContent(entry.getValue()).setAction(logOperation.action())
								.setType(LogTypeEnum.SYSTEM);
						operationLogService.save(logRecord);
					}
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage(), e);
			String exceptionMessage = ExceptionMessageUtil.appendNewException(e);
			MDC.put(MDCParaEnum.EXCEPTION_MESSAGE.getName(), ExceptionMessageUtil.obtainExceptionMessage(e));
			MDC.put(MDCParaEnum.EXCEPTION_DETAIL.getName(), exceptionMessage);
			MDC.put(MDCParaEnum.EXCEPTION_CODE.getName(), ExceptionMessageUtil.obtainExceptionCode(e));
		}
	}

	private void threadClear(){
		CommandThreadLocal.clear();
		LogOperationThreadLocal.clear();
	}

	/**
	 * 存放 CommandDTO
	 */
	private void setCommand(RequestDTO request) {
		if(Objects.nonNull(request) && request instanceof CommandRequest){
			CommandRequest<?> commandRequest = (CommandRequest<?>)request;
			CommandThreadLocal.set(commandRequest.getCommandDTO());
		}
	}

	/**
	 * 获取入参
	 */
	private RequestDTO getRequestDTO(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		if (args != null) {
			for (Object arg : args) {
				if (arg instanceof RequestDTO) {
					return (RequestDTO) arg;
				}
			}
		}
		return null;
	}
}
