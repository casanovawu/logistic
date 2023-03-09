package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.LineSubscribe;
import com.suzz.mini.domain.condition.LineSubscribeCondition;

import java.util.List;

/**
 * @author subo
 * @date 2022/8/7 18:49
 **/
public interface LineSubscribeService extends IService<LineSubscribe> {

    void insert(LineSubscribe lineSubscribe);

    void update(LineSubscribe lineSubscribe);

    List<LineSubscribe> queryList(LineSubscribeCondition condition);

    LineSubscribe queryOne(LineSubscribeCondition condition);

    void sendSubscribeMessage(LineSubscribeCondition condition);

    void delete(LineSubscribe lineSubscribe);

}
