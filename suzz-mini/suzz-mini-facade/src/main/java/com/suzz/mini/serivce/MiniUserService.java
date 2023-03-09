package com.suzz.mini.serivce;

import com.suzz.mini.domain.MiniUser;
import com.suzz.mini.domain.MiniUserSession;
import com.suzz.mini.domain.condition.MiniUserCondition;

/**
 * @author subo
 * @date 2022/5/2 15:07
 **/
public interface MiniUserService {

    MiniUserSession getSession(String code);

    boolean checkExist(String openId);

    void createMiniUser(MiniUser miniUser);

    void updateMiniUser(MiniUser miniUser);

    MiniUser auth(MiniUser miniUser);

    MiniUser selectByPrimaryKey(Integer id);

    MiniUser update(MiniUser miniUser);
}
