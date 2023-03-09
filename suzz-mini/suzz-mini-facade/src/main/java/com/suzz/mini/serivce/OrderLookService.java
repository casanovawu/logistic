package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.OrderLook;

/**
 * @author subo
 * @date 2022/7/31 10:50
 **/
public interface OrderLookService extends IService<OrderLook> {

    void createOrUpdate(OrderLook orderLook);
}
