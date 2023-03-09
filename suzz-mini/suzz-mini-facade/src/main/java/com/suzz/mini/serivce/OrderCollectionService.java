package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.OrderCollection;

/**
 * @author subo
 * @date 2022/7/31 10:50
 **/
public interface OrderCollectionService extends IService<OrderCollection> {

    void updateStatus(OrderCollection orderCollection);
}
