package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/8/7 18:45
 **/
@Data
public class PictureDTO implements Serializable {

    private static final long serialVersionUID = 4179227791128043665L;

    private Integer id;

    private Integer miniUserId;

    private String name;

    private String url;

    private String md5;
}
