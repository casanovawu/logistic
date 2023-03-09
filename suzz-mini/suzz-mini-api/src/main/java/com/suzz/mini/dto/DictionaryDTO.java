package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/19 13:50
 **/
@Data
public class DictionaryDTO implements Serializable {

    private static final long serialVersionUID = -107013981395905819L;

    private Integer key;

    private String name;
}
