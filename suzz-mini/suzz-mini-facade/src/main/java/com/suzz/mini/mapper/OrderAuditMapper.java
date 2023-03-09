package com.suzz.mini.mapper;

import java.util.List;

import com.suzz.mini.domain.OrderAudit;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-19
 */
@Mapper
public interface OrderAuditMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    OrderAudit selectOrderAuditById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param orderAudit 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<OrderAudit> selectOrderAuditList(OrderAudit orderAudit);

    /**
     * 新增【请填写功能名称】
     *
     * @param orderAudit 【请填写功能名称】
     * @return 结果
     */
    int insertOrderAudit(OrderAudit orderAudit);

    /**
     * 修改【请填写功能名称】
     *
     * @param orderAudit 【请填写功能名称】
     * @return 结果
     */
    int updateOrderAudit(OrderAudit orderAudit);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    int deleteOrderAuditById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOrderAuditByIds(Long[] ids);
}
