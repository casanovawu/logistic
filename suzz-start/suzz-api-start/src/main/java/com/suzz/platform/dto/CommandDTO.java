package com.suzz.platform.dto;

import com.suzz.platform.exception.ProgramException;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/4/22 23:59
 **/
public class CommandDTO implements Serializable {

    private static final long serialVersionUID = -1674822099016541440L;

    @ApiModelProperty(
            value = "用户ID",
            dataType = "Integer",
            example = "10000",
            required = true
    )
    private Integer user;
    @ApiModelProperty(
            value = "用户名",
            dataType = "String",
            example = "admin",
            required = true
    )
    private String userName;
    @ApiModelProperty(
            value = "用户真实姓名",
            dataType = "String",
            example = "黄奕铭",
            required = true
    )
    private String userTrueName;
    @ApiModelProperty(
            value = "公司ID",
            dataType = "Integer",
            example = "61",
            required = true
    )
    private Integer companyId;
    @ApiModelProperty(
            value = "公司名称",
            dataType = "String",
            example = "旅行社",
            required = true
    )
    private String companyName;
    @ApiModelProperty(
            value = "部门ID",
            dataType = "Integer",
            example = "1366",
            required = true
    )
    private Integer departmentId;
    @ApiModelProperty(
            value = "部门名称",
            dataType = "Integer",
            example = "销售部",
            required = true
    )
    private String departmentName;
    @ApiModelProperty(
            value = "客户端IP",
            dataType = "String",
            example = "145.12.47.56",
            required = true
    )
    private String clientIp;

    public CommandDTO() {
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setUser(Long user) {
        this.user = getIntValue(user);
        if (Objects.nonNull(user)) {
            String message = "用户ID[" + user + "]超出Integer最大值";
            ProgramException.assertNotNull(this.user, message);
        }

    }

    public Long getUserAsLong() {
        return getLongValue(this.user);
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = getIntValue(companyId);
        if (Objects.nonNull(companyId)) {
            String message = "公司ID" + companyId + "超出Integer最大值";
            ProgramException.assertNotNull(this.companyId, message);
        }

    }

    public Long getCompanyIdAsLong() {
        return getLongValue(this.companyId);
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = getIntValue(departmentId);
        if (Objects.nonNull(departmentId)) {
            String message = "部门ID" + departmentId + "超出Integer最大值";
            ProgramException.assertNotNull(this.departmentId, message);
        }

    }

    public Long getDepartmentIdAsLong() {
        return getLongValue(this.departmentId);
    }

    private static Integer getIntValue(Long value) {
        if (Objects.nonNull(value)) {
            return value > 2147483647L ? null : value.intValue();
        } else {
            return null;
        }
    }

    private static Long getLongValue(Integer value) {
        return Objects.nonNull(value) ? value.longValue() : null;
    }

    public String toString() {
        return "CommandDTO(user=" + this.getUser() + ", userName=" + this.getUserName() + ", userTrueName=" + this.getUserTrueName() + ", companyId=" + this.getCompanyId() + ", companyName=" + this.getCompanyName() + ", departmentId=" + this.getDepartmentId() + ", departmentName=" + this.getDepartmentName() + ", clientIp=" + this.getClientIp() + ")";
    }

    public Integer getUser() {
        return this.user;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserTrueName(final String userTrueName) {
        this.userTrueName = userTrueName;
    }

    public String getUserTrueName() {
        return this.userTrueName;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public Integer getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setClientIp(final String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientIp() {
        return this.clientIp;
    }
}
