package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/8/7 18:45
 **/
@Data
public class PictureQueryDTO implements Serializable {

    private static final long serialVersionUID = -8606856533646238100L;

    private Integer id;

    private Integer miniUserId;

    private String md5;
}
