package com.suzz.mini.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/8/7 18:45
 **/
@Data
public class PictureDeleteVO {

    @NotNull(message = "图片id不能为空")
    private Integer id;

}
