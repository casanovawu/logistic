package com.suzz.mini.dto.mgt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderMgtDTO implements Serializable {

    /**
     * $column.columnComment
     */
    private Integer id;

    private String userName;

    /**
     * 用户id
     */
    private Integer fkMiniUser;

    /**
     * 1.审核中 2.已上架 3.已下架 4.审核拒绝
     */
    private Integer status;

    /**
     * 出发区域code 6位数 2位省份2位城市 2位区域
     */
    private String departureAreaCode;

    /**
     * 目的区域code 6位数 2位省份2位城市 2位区域
     */
    private String arriveAreaCode;

    private String departureAddressName;

    private String arriveAddressName;

    /**
     * 使用开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date useStartDate;

    /**
     * 最小吨位
     */
    private Integer minTon;

    /**
     * 最大吨位
     */
    private Integer maxTon;

    /**
     * 价格方式 1.价格 2.电议
     */
    private Integer priceStyle;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 货源信息
     */
    private String goodsInfo;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date modifyTime;

    /**
     * 创建人
     */
    private Long fkCreateUser;

    /**
     * 更新人
     */
    private Long fkModifyUser;

    /**
     * 1.有效 0.无效
     */
    private Integer isValid;

    private List<CarTypeMgtDTO> carList;

    private List<AuditMgtDTO> auditList;
}
