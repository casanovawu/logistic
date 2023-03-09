package com.suzz.mini.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suzz.mini.domain.MiniUserFocus;

/**
 * @author subo
 * @date 2022/7/31 10:50
 **/
public interface MiniUserFocusService extends IService<MiniUserFocus> {

    void updateStatus(MiniUserFocus miniUserFocus);
}
