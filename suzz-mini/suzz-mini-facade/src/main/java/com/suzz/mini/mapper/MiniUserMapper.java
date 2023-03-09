package com.suzz.mini.mapper;

import com.suzz.mini.domain.MiniUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MiniUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MiniUser record);

    int insertSelective(MiniUser record);

    MiniUser selectByPrimaryKey(Integer id);

    MiniUser selectByOpenId(@Param("openId") String openId);

    int updateByPrimaryKeySelective(MiniUser record);

    int updateByPrimaryKey(MiniUser record);
}