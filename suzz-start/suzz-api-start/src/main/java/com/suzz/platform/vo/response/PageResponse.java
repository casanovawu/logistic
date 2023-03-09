package com.suzz.platform.vo.response;

import com.suzz.platform.dto.PaginationDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/2 15:57
 **/
@Getter
@Setter
public class PageResponse <T> extends ListResponse<T>{

    @ApiModelProperty(
            value = "分页信息",
            required = true
    )
    private PaginationDTO paginationDTO;

    public PageResponse(List<T> data, long totalCount, int pageSize, int pageNumber) {
        super(data);
        this.paginationDTO = new PaginationDTO(pageSize, pageNumber);
        this.paginationDTO.setTotalCount(totalCount);
    }

    public PageResponse(List<T> data, PaginationDTO paginationDTO) {
        super(data);
        this.paginationDTO = paginationDTO;
    }

    public static <T> PageResponse<T> empty() {
        PageResponse<T> resp = new PageResponse();
        resp.setData(Collections.emptyList());
        resp.setPaginationDTO(PaginationDTO.empty());
        return resp;
    }

    public static <T> PageResponse<T> of(List<T> data, PaginationDTO paginationDTO) {
        return new PageResponse(data, paginationDTO);
    }

    public PaginationDTO getPaginationDTO() {
        return this.paginationDTO;
    }

    public void setPaginationDTO(final PaginationDTO paginationDTO) {
        this.paginationDTO = paginationDTO;
    }

    public String toString() {
        return "PageResponse(paginationDTO=" + this.getPaginationDTO() + ")";
    }

    public PageResponse() {
    }


    protected boolean canEqual(final Object other) {
        return other instanceof PageResponse;
    }

}
