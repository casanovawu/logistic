package com.suzz.mini.serivce;

import com.suzz.mini.domain.condition.CityCondition;
import com.suzz.mini.domain.organization.City;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 16:30
 **/
public interface CityService {

    List<City> queryList(CityCondition cityCondition);
}
