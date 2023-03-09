package com.suzz.platform.interceptor;

import com.suzz.platform.util.LangContent;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author subo
 * @date 2022/5/20 1:10
 **/
public class RequestHeaderContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        initHeaderContext(request);
        return super.preHandle(request, response, handler);
    }

    private void initHeaderContext(HttpServletRequest request){
        String language = request.getHeader("Accept-Language");
        LangContent.setLang(language);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LangContent.cleanLang();
        super.postHandle(request, response, handler, modelAndView);
    }
}
