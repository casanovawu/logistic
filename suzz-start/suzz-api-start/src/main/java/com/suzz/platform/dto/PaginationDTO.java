package com.suzz.platform.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/5/2 15:45
 **/
@ApiModel
@Getter
@Setter
public class PaginationDTO implements Serializable {

    private static final long serialVersionUID = -8943951819564302345L;

    @ApiModelProperty(
            value = "页号",
            required = true,
            example = "1",
            dataType = "Integer"
    )
    private Integer pageNumber;
    @ApiModelProperty(
            value = "分页大小",
            required = true,
            example = "20",
            dataType = "Integer"
    )
    private Integer pageSize;
    @ApiModelProperty(
            value = "记录总数",
            example = "102",
            dataType = "Integer"
    )
    private Long totalCount;
    @ApiModelProperty(
            value = "总页数",
            example = "8",
            dataType = "Integer"
    )
    private Long totalPages;

    @ApiModelProperty(
            value = "排序列",
            example = "id",
            dataType = "String"
    )
    private String orderByColumn;

    @ApiModelProperty(
            value = "分页参数合理化",
            example = "true",
            dataType = "Boolean"
    )
    private Boolean reasonable = true;

    public PaginationDTO(int pageSize, int pageNumber) {
        this.pageNumber = 1;
        this.pageSize = 20;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = 0L;
        this.totalCount = 0L;
    }

    public PaginationDTO(int pageSize, int pageNumber, long total) {
        this(pageSize, pageNumber);
        this.totalCount = total;
        if (pageSize != 0) {
            int s = total % (long) pageSize == 0L ? 0 : 1;
            this.totalPages = total / (long) pageSize + (long) s;
        } else {
            this.totalPages = 0L;
        }

    }

    public Long getStart() {
        if (this.pageNumber < 1) {
            this.pageNumber = 1;
        }

        return (long) ((this.pageNumber - 1) * this.pageSize);
    }

    public Long getEnd() {
        return this.getStart() + Long.valueOf((long) this.pageSize);
    }

    public static PaginationDTO empty() {
        return new PaginationDTO(0, 0, 0L);
    }

    public static PaginationDTO defaultPage() {
        return new PaginationDTO(20, 1);
    }

    public boolean hasPreviousPage() {
        return Objects.nonNull(this.pageNumber) && this.pageNumber > 1;
    }

    public boolean hasNextPage() {
        if (Objects.isNull(this.pageNumber) || this.pageNumber <= 0 || Objects.isNull(this.pageSize) || this.pageSize <= 0 || Objects.isNull(this.totalPages) && Objects.isNull(this.totalCount)) {
            return false;
        } else if (Objects.nonNull(this.totalPages)) {
            return (long) this.pageNumber < this.totalPages;
        } else if (Objects.nonNull(this.totalCount)) {
            long m = this.totalCount / (long) this.pageSize;
            long n = this.totalCount % (long) this.pageSize;
            if (n > 0L) {
                ++m;
            }

            return (long) this.pageSize < m;
        } else {
            return false;
        }
    }

    public PaginationDTO() {
        this.pageNumber = 1;
        this.pageSize = 20;
    }
}
