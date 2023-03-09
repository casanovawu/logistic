package com.suzz.mini.vo;

import lombok.Data;


/**
 * @author subo
 * @date 2022-08-18 11:13
 **/
@Data
public class SysConfigVO {

    private Long id;

    private String paramKey;

    private String paramValue;

    private String remark;
}
