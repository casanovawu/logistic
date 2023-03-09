package com.suzz.platform.vo.request;

import com.suzz.platform.dto.PaginationDTO;
import com.suzz.platform.dto.SortDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/5/2 15:44
 **/
@Getter
@Setter
public class PageRequest<T> extends SimpleRequest<T> {

    private static final long serialVersionUID = 2157353296723339131L;
    @ApiModelProperty(
            value = "分页信息",
            required = true
    )
    @NotNull(
            message = "分页参数不能为空"
    )
    private PaginationDTO paginationDTO;
    @ApiModelProperty("排序信息")
    private SortDTO sortDTO;

    public PageRequest(T reqDtos, PaginationDTO dto) {
        super(reqDtos);
        this.paginationDTO = dto;
    }

    public PageRequest(){

    }
    public static <T> PageRequest<T> of(T reqDtos, PaginationDTO dto, SortDTO sortDTO) {
        PageRequest<T> pageRequest = new PageRequest(reqDtos, dto);
        pageRequest.setSortDTO(sortDTO);
        return pageRequest;
    }

}
