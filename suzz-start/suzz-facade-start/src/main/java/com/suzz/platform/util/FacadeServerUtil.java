package com.suzz.platform.util;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.suzz.platform.dto.PaginationDTO;
import com.suzz.platform.dto.SortDTO;
import com.suzz.platform.vo.request.PageRequest;
import com.suzz.platform.vo.response.PageResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: liuhang@lakala.com
 * @createDate: 2022/6/7 11:00
 * @version: 1.0
 * @description:
 */
public class FacadeServerUtil {

    /**
     * @param request               分页请求参数
     * @param paramConvertFunction  入参转换方法
     * @param queryFunction         查询方法
     * @param resultConvertFunction 结果转换方法
     * @param <D>                   查询方法入参类型
     * @param <E>                   查询结果类型
     * @param <V>                   输出类型
     * @return 分页结果
     */
    public static <D, E, V> PageResponse<V> pagingQuery(PageRequest<D> request,
                                                        Function<D, E> paramConvertFunction,
                                                        Function<E, List<E>> queryFunction,
                                                        Function<E, V> resultConvertFunction) {
        SortDTO sortDTO = request.getSortDTO();
        PaginationDTO paginationDTO = request.getPaginationDTO();
        Page<Object> page;
        if (sortDTO != null && sortDTO.getSortField() != null && !"".equals(sortDTO.getSortField())) {
            page = PageHelper.startPage(paginationDTO.getPageNumber(),
                    paginationDTO.getPageSize(),
                    sortDTO.getSortField() + " " + sortDTO.getSortType()).setReasonable(paginationDTO.getReasonable());
        } else {
            page = PageHelper.startPage(paginationDTO.getPageNumber(),
                    paginationDTO.getPageSize()).setReasonable(paginationDTO.getReasonable());
        }
        E param = paramConvertFunction.apply(request.getReqDtos());
        List<E> apply = queryFunction.apply(param);
        PageResponse<V> pageResponse = new PageResponse<>();
        if (CollUtil.isEmpty(apply)) {
            pageResponse.setData(new ArrayList<>());
        } else {
            List<V> result = apply.stream().filter(Objects::nonNull).map(resultConvertFunction)
                    .filter(Objects::nonNull).collect(Collectors.toList());
            pageResponse.setData(result);
        }
        paginationDTO.setPageNumber(page.getPageNum());
        paginationDTO.setPageSize(page.getPageSize());
        paginationDTO.setTotalCount(page.getTotal());
        paginationDTO.setTotalPages(Long.valueOf(page.getPages()));
        pageResponse.setPaginationDTO(paginationDTO);
        return pageResponse;
    }
}
