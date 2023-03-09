package com.suzz.mini.domain.condition;

import com.suzz.mini.dto.driven.LineSubscribeQueryDetailDTO;
import com.suzz.mini.dto.driven.LineSubscribeQueryListDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author subo
 * @date 2022/8/9 21:23
 **/
@Data
public class LineSubscribeCondition {

    private Integer id;

    private Integer miniUserId;

    private Date useStartDate;

    private String departureAreaCode;

    private String arriveAreaCode;

    private List<Integer> carTypeList;
    /**
     * 价格方式 1.价格 2.电议
     */
    private Integer priceStyle;

    /**
     * 价格
     */
    private BigDecimal price;

    public static LineSubscribeCondition toLineSubscribeCondition(LineSubscribeQueryListDTO lineSubscribeQueryListDTO){
        LineSubscribeCondition lineSubscribeCondition = new LineSubscribeCondition();
        lineSubscribeCondition.setMiniUserId(lineSubscribeQueryListDTO.getMiniUserId());
        return lineSubscribeCondition;
    }

    public static LineSubscribeCondition toLineSubscribeCondition(LineSubscribeQueryDetailDTO lineSubscribeQueryDetailDTO){
        LineSubscribeCondition lineSubscribeCondition = new LineSubscribeCondition();
        lineSubscribeCondition.setId(lineSubscribeQueryDetailDTO.getId());
        return lineSubscribeCondition;
    }
}
