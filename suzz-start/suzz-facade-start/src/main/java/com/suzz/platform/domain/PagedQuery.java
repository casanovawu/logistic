package com.suzz.platform.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author subo
 * @date 2022/5/2 15:53
 **/
@Setter
@Getter
public abstract class PagedQuery {

    /** 分页页码 */
    private Integer pageNumber;

    /** 每页大小 */
    private Integer pageSize;

    /** 排序对象 */
    private String sortBy;

    /** 排序方式 */
    private String sortMethod;

    /** ture 时不用分页 */
    private Boolean pageSizeZero;
}
