package com.suzz.mini.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.domain.OrderCollection;
import com.suzz.mini.mapper.OrderCollectionMapper;
import com.suzz.mini.serivce.OrderCollectionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/7/31 10:53
 **/
@Service
public class OrderCollectionServiceImpl extends ServiceImpl<OrderCollectionMapper, OrderCollection> implements OrderCollectionService {

    @Override
    public void updateStatus(OrderCollection orderCollection) {
        if(orderCollection.getIsCollection()==0){
            this.baseMapper.delete(new LambdaUpdateWrapper<OrderCollection>()
                    .eq(OrderCollection::getOrderId,orderCollection.getOrderId())
                    .eq(OrderCollection::getMiniUserId,orderCollection.getMiniUserId()));
        }
        if(orderCollection.getIsCollection()==1){
            OrderCollection orderCollectionExist = this.getBaseMapper().queryInValidData(orderCollection);
            if(Objects.nonNull(orderCollectionExist)){
                this.baseMapper.updateValid(orderCollection);
            }else {
                this.baseMapper.insert(orderCollection);
            }
        }
    }
}
