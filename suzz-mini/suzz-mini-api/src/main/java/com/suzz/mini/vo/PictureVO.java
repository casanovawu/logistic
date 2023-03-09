package com.suzz.mini.vo;

import lombok.Data;

/**
 * @author subo
 * @date 2022/8/7 18:45
 **/
@Data
public class PictureVO {

    private Integer id;

    private Integer miniUserId;

    private String url;

    private String name;

    private String md5;
}
