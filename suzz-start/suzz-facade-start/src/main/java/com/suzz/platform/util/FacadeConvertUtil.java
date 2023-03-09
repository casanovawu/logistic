package com.suzz.platform.util;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.Page;
import com.suzz.platform.domain.PagedQuery;
import com.suzz.platform.dto.PaginationDTO;
import com.suzz.platform.dto.ResponseDTO;
import com.suzz.platform.dto.SortDTO;
import com.suzz.platform.vo.request.CommandPageRequest;
import com.suzz.platform.vo.request.CommandRequest;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.PageResponse;
import com.suzz.platform.vo.response.SimpleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * facade 返回结果组装
 */
public class FacadeConvertUtil {

    /**
     * 转换请求参数
     */
    public static <P, R> R convertForCommand(CommandRequest<P> commandRequest, Function<P, R> function) {
        if (Objects.nonNull(commandRequest)) {
            return function.apply(commandRequest.getReqDtos());
        }
        return null;
    }

    /**
     * 转换请求参数
     */
    public static <P> CommandRequest<P> convertForCommand(P p) {
        CommandRequest<P> commandRequest = new CommandRequest<>();
        commandRequest.setReqDtos(p);
        commandRequest.setCommandDTO(CommandThreadLocal.get());
        return commandRequest;
    }


    /**
     * 转换分页请求参数为 data query
     */
    public static <P, R> CommandRequest<R> convert(CommandRequest<P> commandRequest, Function<P, R> function) {
        if (Objects.nonNull(commandRequest)) {
            R r = function.apply(commandRequest.getReqDtos());
            CommandRequest<R> result = new CommandRequest<>();
            result.setReqDtos(r);
            result.setCommandDTO(commandRequest.getCommandDTO());
            return result;
        }
        return null;
    }

    /**
     * 转换分页请求参数为 data query
     */
    public static <P, R extends PagedQuery> R convertForPageByCommand(CommandPageRequest<P> pageRequest, Function<P, R> function) {
        if (Objects.nonNull(pageRequest)) {
            R r = function.apply(pageRequest.getReqDtos());
            PaginationDTO paginationDTO = pageRequest.getPaginationDTO();
            if (Objects.nonNull(paginationDTO) && Objects.nonNull(r)) {
                r.setPageNumber(paginationDTO.getPageNumber());
                r.setPageSize(paginationDTO.getPageSize());
            }
            SortDTO sortDTO = pageRequest.getSortDTO();
            if (Objects.nonNull(sortDTO) && Objects.nonNull(r)) {
                r.setSortBy(sortDTO.getSortField());
                r.setSortMethod(sortDTO.getSortType());
            }
            return r;
        }
        return null;
    }

    public static <P, R extends PagedQuery> R convertForPage(PageRequest<P> pageRequest, Function<P, R> function) {
        if (Objects.nonNull(pageRequest)) {
            R r = function.apply(pageRequest.getReqDtos());
            PaginationDTO paginationDTO = pageRequest.getPaginationDTO();
            if (Objects.nonNull(paginationDTO) && Objects.nonNull(r)) {
                r.setPageNumber(paginationDTO.getPageNumber());
                r.setPageSize(paginationDTO.getPageSize());
            }
            SortDTO sortDTO = pageRequest.getSortDTO();
            if (Objects.nonNull(sortDTO) && Objects.nonNull(r)) {
                r.setSortBy(sortDTO.getSortField());
                r.setSortMethod(sortDTO.getSortType());
            }
            return r;
        }
        return null;
    }

    /**
     * 添加默认分页参数,并且设置不用分页
     */
    public static <P, R extends PagedQuery> R convertForWithPageParamsNoPage(CommandRequest<P> pageRequest, Function<P, R> function) {
        R r = function.apply(pageRequest.getReqDtos());
        r.setPageNumber(1);
        r.setPageSize(Integer.MAX_VALUE);
        r.setPageSizeZero(Boolean.TRUE);
        return r;
    }

    /**
     * 无数据设置, 返回操作成功
     */
    public static ResponseDTO success() {
        return new ResponseDTO();
    }

    /**
     * 有数据设置, 返回操作成功
     */
    public static <P, R> SimpleResponse<R> success(P p, Function<P, R> function) {
        SimpleResponse<R> simpleResponse = new SimpleResponse<>();
        if(Objects.nonNull(p)){
            simpleResponse.setData(function.apply(p));
        }
        return simpleResponse;
    }

    /**
     * 有列表数据设置, 返回操作成功
     */
    public static <P, R> ListResponse<R> successForList(List<P> ps, Function<P, R> function) {
        ListResponse<R> listResponse = new ListResponse<>();
        if (CollUtil.isEmpty(ps)) {
            listResponse.setData(new ArrayList<>());
        } else {
            List<R> result = ps.stream().filter(Objects::nonNull).map(function)
                    .filter(Objects::nonNull).collect(Collectors.toList());
            listResponse.setData(result);
        }
        return listResponse;
    }

    /**
     * 分页列表数据设置, 返回操作成功
     */
    public static <P, R> PageResponse<R> successForPage(List<P> ps, Function<P, R> function) {
        PageResponse<R> pageResponse = new PageResponse<>();
        if (CollUtil.isEmpty(ps)) {
            pageResponse.setData(new ArrayList<>());
        } else {
            List<R> result = ps.stream().filter(Objects::nonNull).map(function)
                    .filter(Objects::nonNull).collect(Collectors.toList());
            pageResponse.setData(result);
        }
        if (ps instanceof Page) {
            Page<P> page = (Page<P>) ps;
            PaginationDTO paginationDTO = new PaginationDTO();
            paginationDTO.setPageNumber(page.getPageNum());
            paginationDTO.setPageSize(page.getPageSize());
            paginationDTO.setTotalCount(page.getTotal());
            paginationDTO.setTotalPages(Long.valueOf(page.getPages()));
            pageResponse.setPaginationDTO(paginationDTO);
        }
        return pageResponse;
    }

}
