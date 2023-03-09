package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suzz.mini.dto.PictureDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/8/7 18:42
 **/
@Data
@TableName(value = "picture")
public class Picture  {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_mini_user")
    private Integer miniUserId;

    private String name;

    private String url;

    private String md5;

    public static Picture toPicture(PictureDTO pictureDTO){
        Picture picture = new Picture();
        picture.setId(pictureDTO.getId());
        picture.setMiniUserId(pictureDTO.getMiniUserId());
        picture.setUrl(pictureDTO.getUrl());
        picture.setName(pictureDTO.getName());
        picture.setMd5(pictureDTO.getMd5());
        return picture;
    }

    public PictureDTO toPictureDTO(){
        PictureDTO pictureDTO=new PictureDTO();
        pictureDTO.setMd5(this.md5);
        pictureDTO.setUrl(this.url);
        pictureDTO.setId(this.id);
        pictureDTO.setName(this.name);
        return pictureDTO;
    }
}
