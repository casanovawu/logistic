package com.suzz.mini.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suzz.mini.domain.config.SysConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

	/**
	 * 根据key，查询系统配置信息
	 * @param key key
	 * @return SysConfig
	 */
	SysConfig queryByKey(String key);

	/**
	 * 根据key，更新value
	 * @param key
	 * @param value
	 * @return 更新成功条数
	 */
	int updateValueByKey(@Param("key") String key, @Param("value") String value);

	/**
	 * 批量删除系统配置
	 * @param ids 系统配置信息数组
	 */
	void deleteBatch(@Param("ids") Long[] ids);

}
