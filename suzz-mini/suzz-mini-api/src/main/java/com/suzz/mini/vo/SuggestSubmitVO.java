package com.suzz.mini.vo;

import lombok.Data;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/7 21:17
 **/
@Data
public class SuggestSubmitVO {

    private Integer miniSuggestUserId;

    private Integer orderId;

    private Integer type;

    private String content;

    private String contactName;

    private String contactPhone;

    private List<Integer> pictureList;

}
