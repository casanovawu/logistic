package com.suzz.mini.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author subo
 * @date 2022-08-09 13:16
 **/
@Data
@TableName("line_subscribe_car_type")
public class LineSubscribeCarType  {

    @TableId(type= IdType.AUTO)
    private Integer id;

    @TableField("fk_line_subscribe")
    private Integer lineSubscribeId;

    @TableField("car_type")
    private Integer carType;
}
