package com.suzz.mini.domain.organization;


import lombok.Data;

import java.io.Serializable;

/**
 * city_lang
 * @author 
 */
@Data
public class CityLang  implements Serializable {

    private static final long serialVersionUID = 1998771394730915515L;

    private Integer id;

    /**
     * 城市id
     */
    private Integer fkCity;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 语言
     */
    private String lang;

}