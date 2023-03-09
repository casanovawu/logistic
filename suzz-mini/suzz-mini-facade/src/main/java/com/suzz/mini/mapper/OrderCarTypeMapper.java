package com.suzz.mini.mapper;

import com.suzz.mini.domain.OrderCarType;
import com.suzz.mini.domain.condition.OrderCarTypeCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCarTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OrderCarType record);

    int insertSelective(OrderCarType record);

    OrderCarType selectByPrimaryKey(Integer id);

    List<OrderCarType> queryList(OrderCarTypeCondition orderCarTypeCondition);

    int updateByPrimaryKeySelective(OrderCarType record);

    int updateByPrimaryKey(OrderCarType record);

    int updateValid(OrderCarType record);
}