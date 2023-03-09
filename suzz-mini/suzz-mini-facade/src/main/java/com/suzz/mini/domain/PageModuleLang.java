package com.suzz.mini.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * page_module_lang
 * @author 
 */
@Data
public class PageModuleLang  implements Serializable {

    private static final long serialVersionUID = -4672186916479705709L;

    private Integer id;

    /**
     * 页面模块id
     */
    private Integer fkPageModule;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 语言
     */
    private String lang;
}