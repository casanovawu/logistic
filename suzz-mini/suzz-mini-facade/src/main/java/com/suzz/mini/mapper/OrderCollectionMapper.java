package com.suzz.mini.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suzz.mini.domain.OrderCollection;

/**
 * @author subo
 * @date 2022/7/31 10:54
 **/
public interface OrderCollectionMapper extends BaseMapper<OrderCollection> {

    OrderCollection queryInValidData(OrderCollection orderCollection);

    void updateValid(OrderCollection orderCollection);
}
