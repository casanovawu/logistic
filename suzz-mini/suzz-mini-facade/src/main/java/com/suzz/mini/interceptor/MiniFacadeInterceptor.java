package com.suzz.mini.interceptor;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.annotation.Dic;
import com.suzz.mini.annotation.DicMark;
import com.suzz.mini.domain.Dictionary;
import com.suzz.mini.domain.Exception;
import com.suzz.mini.domain.condition.DictionaryCondition;
import com.suzz.mini.domain.condition.ExceptionCondition;
import com.suzz.mini.serivce.DictionaryService;
import com.suzz.mini.serivce.ExceptionService;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.exception.ApplicationException;
import com.suzz.platform.exception.BusinessException;
import com.suzz.platform.exception.ProgramException;
import com.suzz.platform.util.LangContent;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Aspect
@Component
@Order(1)
public class MiniFacadeInterceptor {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ExceptionService exceptionService;

    @Pointcut("execution(public * com.suzz..*.facade.impl..*(..))")
    public void aspect() {
    }

    @Around("aspect()")
    public Object aroundFacade(ProceedingJoinPoint pjp) throws Throwable {
        String lang = LangContent.getLang();
        try {
            Object o = pjp.proceed();
            if (o instanceof ResponseDTO) {
                if (o instanceof ListResponse) {
                    ListResponse<?> listResponse = (ListResponse<?>) o;
                    if (CollUtil.isNotEmpty(listResponse.getData())) {
                        for (Object datum : listResponse.getData()) {
                            setDic(datum,lang);
                        }
                    }
                }else if(o instanceof SimpleResponse){
                    SimpleResponse<?> simpleResponse = (SimpleResponse<?>) o;
                    setDic(simpleResponse.getData(),lang);
                } else {
                    setDic(o, lang);
                }
            }
            return o;
        } catch (ApplicationException e) {
            Exception exception = findException(e.getErrorMsg(), lang);
            if (Objects.nonNull(exception)) {
                if (e instanceof BusinessException) {
                    throw BusinessException.of(exception.getExceptionLang().getName(), e.getErrCode());
                } else if (e instanceof ProgramException) {
                    throw ProgramException.of(exception.getExceptionLang().getName(), e.getErrCode());
                }
                throw ApplicationException.of(exception.getExceptionLang().getName(), e.getErrCode());
            }
            throw e;
        } finally {
            LangContent.cleanLang();
        }
    }

    private Exception findException(String errorMsg, String lang) {
        ExceptionCondition exceptionCondition = new ExceptionCondition();
        exceptionCondition.setLang(lang);
        exceptionCondition.setCode(errorMsg);
        List<Exception> exceptions = exceptionService.queryList(exceptionCondition);
        if (CollUtil.isNotEmpty(exceptions)) {
            return exceptions.get(0);
        }
        return null;
    }

    private void setDic(Object object, String lang) {
        if(Objects.nonNull(object)){
            Class<?> aClass = object.getClass();
            DicMark dicMark = aClass.getAnnotation(DicMark.class);
            if (Objects.nonNull(dicMark)) {
                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    Dic dic = field.getAnnotation(Dic.class);
                    if (Objects.nonNull(dic)) {
                        DictionaryCondition dictionaryCondition = new DictionaryCondition();
                        dictionaryCondition.setCode(dic.code());
                        dictionaryCondition.setLang(lang);
                        List<Dictionary> dictionaries = dictionaryService.queryList(dictionaryCondition);
                        if (CollUtil.isNotEmpty(dictionaries)) {
                            field.setAccessible(true);
                            try {
                                Method getMethod = aClass.getMethod("get" + captureName(field.getName()));
                                Object invoke = getMethod.invoke(object);
                                if(Objects.nonNull(invoke)){
                                    Map<Integer, List<Dictionary>> map = dictionaries.stream().collect(Collectors.groupingBy(Dictionary::getKey));
                                    Class<?> type = aClass.getDeclaredField(dic.target()).getType();
                                    Method setMethod = aClass.getMethod("set" + captureName(dic.target()), type);
                                    if (invoke instanceof List) {
                                        List<Integer> list = (List) invoke;
                                        List<String> values = new ArrayList<>();
                                        for (Integer integer : list) {
                                            List<Dictionary> dictionaryList = map.get(integer);
                                            values.add(dictionaryList.get(0).getDictionaryLang().getName());
                                        }
                                        setMethod.invoke(object, values);
                                    } else {
                                        int key = (int) invoke;
                                        List<Dictionary> dictionaryList = map.get(key);
                                        if(CollUtil.isNotEmpty(dictionaryList)){
                                            String value = dictionaryList.get(0).getDictionaryLang().getName();
                                            setMethod.invoke(object, value);
                                        }
                                    }
                                }
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException | NoSuchMethodException e) {
                                log.error("字典值赋值失败,对象:" + object + "字段名称:" + field.getName());
                            }
                        }
                    }
                }
            }
        }
    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}
