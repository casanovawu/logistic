package com.suzz.mini.serivce;

import com.suzz.mini.domain.condition.AreaCondition;
import com.suzz.mini.domain.organization.Area;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:39
 **/
public interface AreaService {

    List<Area> queryList(AreaCondition areaCondition);
}
