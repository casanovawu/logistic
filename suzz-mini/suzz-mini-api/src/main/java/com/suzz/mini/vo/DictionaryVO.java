package com.suzz.mini.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author subo
 * @date 2022/5/15 19:19
 **/
@Data
@ApiModel
public class DictionaryVO {

   private Integer key;

   private String name;
}
