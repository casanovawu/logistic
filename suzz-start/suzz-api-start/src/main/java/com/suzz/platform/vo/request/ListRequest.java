package com.suzz.platform.vo.request;

import com.suzz.platform.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ListRequest<T> extends RequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请求列表参数", required = true)
    @NotEmpty(message = "请求列表参数不能为空")
    private List<T> data;

    public ListRequest(List<T> list) {
        this.data = list;
    }

    public static <T> ListRequest<T> of(List<T> list) {
        return new ListRequest<T>(list);
    }
}
