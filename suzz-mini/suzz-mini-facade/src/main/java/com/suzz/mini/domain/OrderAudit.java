package com.suzz.mini.domain;

import lombok.Data;

/**
 * 【请填写功能名称】对象 order_audit
 *
 * @author ruoyi
 * @date 2022-06-19
 */
@Data
public class OrderAudit  {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 订单id
     */
    private Integer fkOrder;

    /**
     * 审批人
     */
    private Long fkAuditUser;

    /**
     * 审批姓名
     */
    private String auditUserName;

    /**
     * 1.审核通过 2.审核拒绝
     */
    private Long status;

    /**
     * 审批拒绝理由
     */
    private String rejectRemark;

    /**
     * 审核内容
     */
    private String auditContent;

}
