package com.suzz.mini.domain.organization;


import lombok.Data;

import java.io.Serializable;

/**
 * province_lang
 * @author 
 */
@Data
public class ProvinceLang  implements Serializable {


    private static final long serialVersionUID = -4165781016218336200L;

    private Integer id;

    /**
     * 省份id
     */
    private Integer fkProvince;

    /**
     * 省份名称
     */
    private String name;

    /**
     * 语言
     */
    private String lang;

}