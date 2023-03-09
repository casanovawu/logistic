package com.suzz.mini.domain.config;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suzz.mini.dto.SysConfigDTO;
import com.suzz.mini.dto.SysConfigDeleteDTO;
import lombok.Data;


/**
 * 系统配置信息
 */
@Data
@TableName("sys_config")
public class SysConfig {
	@TableId
	private Long id;

	/**
	 * 参数名
	 */
	private String paramKey;

	/**
	 * 参数值
	 */
	private String paramValue;

	/**
	 * 备注
	 */
	private String remark;

	public SysConfigDTO convertTOSysConfigDTO(){
		SysConfigDTO sysConfigDTO=new SysConfigDTO();
		sysConfigDTO.setId(id);
		sysConfigDTO.setParamKey(paramKey);
		sysConfigDTO.setParamValue(paramValue);
		sysConfigDTO.setRemark(remark);
		return sysConfigDTO;
	}

	public static SysConfig convertToSysConfig(SysConfigDTO sysConfigDTO){
		SysConfig sysConfig=new SysConfig();
		sysConfig.setId(sysConfigDTO.getId());
		sysConfig.setParamKey(sysConfigDTO.getParamKey());
		sysConfig.setParamValue(sysConfigDTO.getParamValue());
		sysConfig.setRemark(sysConfigDTO.getRemark());
		return sysConfig;
	}

	public static SysConfig convertToSysConfig(SysConfigDeleteDTO sysConfigDeleteDTO){
		SysConfig sysConfig=new SysConfig();
		sysConfig.setParamKey(sysConfigDeleteDTO.getParamKey());
		return sysConfig;
	}

}
