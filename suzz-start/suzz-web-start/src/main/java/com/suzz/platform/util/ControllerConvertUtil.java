package com.suzz.platform.util;

import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author subo
 * @date 2022/5/15 17:34
 **/
public class ControllerConvertUtil {

    /**
     * 转换请求参数
     */
    public static <P, R> SimpleRequest<R> convertForSimple(SimpleRequest<P> simpleRequest, Function<P, R> function) {
        SimpleRequest<R> request = new SimpleRequest<>();
        if (Objects.nonNull(simpleRequest)) {
            R apply = function.apply(simpleRequest.getReqDtos());
            request.setReqDtos(apply);
        }
        return request;
    }

    /**
     * 转换请求参数
     */
    public static <P, R> SimpleResponse<R> successForSimple(SimpleResponse<P> simpleResponse, Function<P, R> function) {
        SimpleResponse<R> response = new SimpleResponse<>();
        if (Objects.nonNull(simpleResponse)) {
            R apply = function.apply(simpleResponse.getData());
            response.setData(apply);
        }
        return response;
    }

    /**
     * 转换请求参数
     */
    public static <P, R> PageRequest<R> convertForPage(PageRequest<P> pageRequest, Function<P, R> function) {
        PageRequest<R> request = new PageRequest<>();
        if (Objects.nonNull(pageRequest)) {
            request.setPaginationDTO(pageRequest.getPaginationDTO());
            request.setSortDTO(pageRequest.getSortDTO());
            R apply = function.apply(pageRequest.getReqDtos());
            request.setReqDtos(apply);
        }
        return request;
    }

    /**
     * 转换请求参数
     */
    public static <P, R> PageResponse<R> successForList(ListResponse<P> listResponse, Function<P, R> function) {
        PageResponse<R> response = new PageResponse<>();
        if (Objects.nonNull(listResponse)) {
            List<R> list = new ArrayList<>();
            for (P p : listResponse.getData()) {
                R r = function.apply(p);
                list.add(r);
            }
            response.setData(list);
        }
        return response;
    }

    /**
     * 转换请求参数
     */
    public static <P, R> PageResponse<R> successForPage(PageResponse<P> pageResponse, Function<P, R> function) {
        PageResponse<R> response = new PageResponse<>();
        if (Objects.nonNull(pageResponse)) {
            List<R> list = new ArrayList<>();
            response.setPaginationDTO(pageResponse.getPaginationDTO());
            for (P p : pageResponse.getData()) {
                R r = function.apply(p);
                list.add(r);
            }
            response.setData(list);
        }
        return response;
    }

}
