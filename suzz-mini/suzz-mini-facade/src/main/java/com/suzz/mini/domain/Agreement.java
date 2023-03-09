package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author subo
 * @date 2023/1/4 21:23
 **/
@Data
@TableName("agreement")
public class Agreement {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("text")
    private String text;
}
