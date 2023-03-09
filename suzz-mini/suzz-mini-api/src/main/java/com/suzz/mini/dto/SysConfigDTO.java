package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * @author subo
 * @date 2022-08-18 11:13
 **/
@Data
public class SysConfigDTO implements Serializable {

    private static final long serialVersionUID = -8318238820322143739L;

    private Long id;

    private String paramKey;

    private String paramValue;

    private String remark;
}
