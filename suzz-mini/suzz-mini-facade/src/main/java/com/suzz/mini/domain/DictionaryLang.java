package com.suzz.mini.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * dictionary_lang
 * @author 
 */
@Data
public class DictionaryLang implements Serializable {

    private static final long serialVersionUID = 2411792861364490166L;

    private Integer id;

    private Integer fkDictionary;

    /**
     * 值
     */
    private String name;

    /**
     * 语言
     */
    private String lang;
}