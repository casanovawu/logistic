package com.suzz.mini.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * exception
 * @author 
 */
@Data
public class Exception implements Serializable {

    private static final long serialVersionUID = 3620951623666181712L;

    private Integer id;

    /**
     * 异常code
     */
    private String code;

    private ExceptionLang exceptionLang;

}