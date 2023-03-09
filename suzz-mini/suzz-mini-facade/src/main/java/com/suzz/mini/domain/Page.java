package com.suzz.mini.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * page
 * @author 
 */
@Data
public class Page  implements Serializable {

    private static final long serialVersionUID = -3403669196925187139L;

    private Integer id;

    /**
     * 页面名称
     */
    private String name;

}