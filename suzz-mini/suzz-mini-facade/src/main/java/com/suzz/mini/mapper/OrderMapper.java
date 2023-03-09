package com.suzz.mini.mapper;

import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.condition.OrderQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> queryList(OrderQueryCondition condition);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int updateStatusMoreThanFiveDay();

    /**
     * 查询【请填写功能名称】列表
     *
     * @param order 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<Order> selectOrderList(Order order);

    /**
     * 审批订单
     *
     * @param id        主键
     * @param newStatus 新的审批状态
     * @param oldStatus 老的审批状态(乐观锁)
     * @return 更新条数
     */
    int audit(@Param("id") Integer id,
              @Param("newStatus") int newStatus,
              @Param("oldStatus") int oldStatus);
}