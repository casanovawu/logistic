package com.suzz.platform.vo.response;

import cn.hutool.core.collection.CollUtil;
import com.suzz.platform.dto.ResponseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author subo
 * @date 2022/5/2 15:56
 **/
@Getter
@Setter
public class ListResponse <R> extends ResponseDTO {

    private static final long serialVersionUID = -5436457158317726657L;

    @ApiModelProperty(
            value = "查询结果列表",
            required = true
    )
    private List<R> data;

    public ListResponse(List<R> list) {
        this.data = list;
    }

    public static <R> ListResponse<R> of(List<R> list) {
        return new ListResponse(list);
    }

    public static <T, R> ListResponse<R> of(List<T> source, Function<T, R> function) {
        List<R> map = CollUtil.map(source, function, true);
        return new ListResponse(map);
    }

    public static <R> ListResponse<R> empty() {
        return new ListResponse(Collections.emptyList());
    }

    public ListResponse() {
    }

    public List<R> getData() {
        return this.data;
    }

    public void setData(final List<R> data) {
        this.data = data;
    }

    public String toString() {
        return "ListResponse(data=" + this.getData() + ")";
    }


    protected boolean canEqual(final Object other) {
        return other instanceof ListResponse;
    }
}
