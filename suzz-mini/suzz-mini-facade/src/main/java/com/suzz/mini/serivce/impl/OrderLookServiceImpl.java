package com.suzz.mini.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.domain.OrderLook;
import com.suzz.mini.mapper.OrderLookMapper;
import com.suzz.mini.serivce.OrderLookService;
import com.suzz.platform.exception.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/7/31 10:53
 **/
@Service
public class OrderLookServiceImpl extends ServiceImpl<OrderLookMapper, OrderLook> implements OrderLookService {

    @Override
    @Transactional
    public void createOrUpdate(OrderLook orderLook) {
        OrderLook orderLookExist = this.baseMapper.queryLock(orderLook);
        orderLook.setModifyTime(new Date());
        orderLook.setLookTime(new Date());
        if(Objects.nonNull(orderLookExist)){
            orderLook.setNum(orderLookExist.getNum()+1);
            this.baseMapper.update(orderLook,new LambdaUpdateWrapper<OrderLook>()
                    .eq(OrderLook::getOrderId, orderLook.getOrderId())
                    .eq(OrderLook::getMiniUserId, orderLook.getMiniUserId())
                    .eq(OrderLook::getLookTime,orderLook.getLookTime())
            );
        }else {
            orderLook.setModifyTime(new Date());
            orderLook.setNum(1);
            this.baseMapper.insert(orderLook);
        }

    }
}
