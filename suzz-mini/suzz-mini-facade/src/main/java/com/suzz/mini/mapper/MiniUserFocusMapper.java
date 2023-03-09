package com.suzz.mini.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suzz.mini.domain.MiniUserFocus;

/**
 * @author subo
 * @date 2022/7/31 10:54
 **/
public interface MiniUserFocusMapper extends BaseMapper<MiniUserFocus> {

    MiniUserFocus queryInValidData(MiniUserFocus miniUserFocus);

    void updateValid(MiniUserFocus miniUserFocus);
}
