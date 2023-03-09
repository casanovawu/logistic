package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author subo
 * @date 2022/10/1 16:24
 **/
@Data
@TableName(value = "notice")
public class Notice {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;
}
