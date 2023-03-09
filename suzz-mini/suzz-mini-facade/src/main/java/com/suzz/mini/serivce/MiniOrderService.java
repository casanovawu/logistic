package com.suzz.mini.serivce;

import com.github.pagehelper.Page;
import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.OrderAudit;
import com.suzz.mini.domain.OrderCarType;
import com.suzz.mini.domain.condition.OrderQueryCondition;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/4 13:23
 **/
public interface MiniOrderService {

    Integer publish(Order order);

    List<Order> queryOrderList(OrderQueryCondition condition);

    Page<Order> queryOrderPage(OrderQueryCondition condition);

    Order queryDetail(OrderQueryCondition condition);

    void updatePublish(Order order);

    void updateStatusMoreThanFiveDay();

    void updateStatus(Order order);

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    Order selectOrderById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param order 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<Order> selectOrderList(Order order);


    /**
     * 修改【请填写功能名称】
     *
     * @param order 【请填写功能名称】
     * @return 结果
     */
    int updateOrder(Order order);

    /**
     * 根据订单编号查询用车列表
     *
     * @param orderId 订单Id
     * @return 结果
     */
    List<OrderCarType> selectCarList(Integer orderId);

    /**
     * 根据订单编号查询用车列表
     *
     * @param orderId 订单Id
     * @return 结果
     */
    List<OrderAudit> selectAuditList(Integer orderId);

    /**
     * 审核订单
     *
     * @param orderAudit 审核内容
     * @return 结果
     * @return 结果
     */
    Integer audit(OrderAudit orderAudit);

}
