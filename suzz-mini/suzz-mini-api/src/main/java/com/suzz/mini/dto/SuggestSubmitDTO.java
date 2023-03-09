package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/8/7 21:17
 **/
@Data
public class SuggestSubmitDTO implements Serializable {

    private static final long serialVersionUID = 2244228732025267209L;

    private Integer miniSuggestUserId;

    private Integer orderId;

    private Integer type;

    private String content;

    private String contactName;

    private String contactPhone;

    private List<Integer> pictureList;

}
