package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author subo
 * @date 2022/8/7 21:19
 **/
@Data
@TableName(value = "suggest_picture_link")
public class SuggestPictureLink  {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_suggest")
    private Integer suggestId;

    @TableField("fk_picture")
    private Integer pictureId;
}
