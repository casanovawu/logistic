package com.suzz.mini.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * exception_lang
 * @author 
 */
@Data
public class ExceptionLang  implements Serializable {

    private static final long serialVersionUID = -4604394900998173007L;

    private Integer id;

    /**
     * 异常主键id
     */
    private Integer fkException;

    /**
     * 语言
     */
    private String lang;

    /**
     * 异常信息
     */
    private String name;

}