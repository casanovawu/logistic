package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/5/15 17:17
 **/
@Data
public class AreaDTO implements Serializable {

    private static final long serialVersionUID = -3493375656017782504L;

    private Integer id;

    private Integer code;

    private String name;
}
