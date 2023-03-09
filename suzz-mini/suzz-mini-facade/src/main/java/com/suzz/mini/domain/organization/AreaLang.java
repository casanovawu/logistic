package com.suzz.mini.domain.organization;


import lombok.Data;

import java.io.Serializable;

/**
 * area_lang
 * @author 
 */
@Data
public class AreaLang  implements Serializable {

    private static final long serialVersionUID = 6207212967352048631L;

    private Integer id;

    /**
     * 区域id
     */
    private Integer fkArea;

    /**
     * 名称
     */
    private String name;

    /**
     * 语言
     */
    private String lang;

}