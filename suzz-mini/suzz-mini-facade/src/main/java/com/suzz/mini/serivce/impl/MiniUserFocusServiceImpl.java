package com.suzz.mini.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suzz.mini.domain.MiniUserFocus;
import com.suzz.mini.mapper.MiniUserFocusMapper;
import com.suzz.mini.serivce.MiniUserFocusService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/7/31 10:53
 **/
@Service
public class MiniUserFocusServiceImpl extends ServiceImpl<MiniUserFocusMapper, MiniUserFocus> implements MiniUserFocusService {

    @Override
    public void updateStatus(MiniUserFocus miniUserFocus) {
        if(miniUserFocus.getIsFocus()==0){
            this.baseMapper.delete(new LambdaUpdateWrapper<MiniUserFocus>()
                    .eq(MiniUserFocus::getMiniUserId,miniUserFocus.getMiniUserId())
                    .eq(MiniUserFocus::getMiniUserFocusId,miniUserFocus.getMiniUserFocusId()));
        }
        if(miniUserFocus.getIsFocus()==1){
            MiniUserFocus miniUserFocusExist = this.getBaseMapper().queryInValidData(miniUserFocus);
            if(Objects.nonNull(miniUserFocusExist)){
                this.baseMapper.updateValid(miniUserFocus);
            }else {
                this.baseMapper.insert(miniUserFocus);
            }
        }
    }
}
