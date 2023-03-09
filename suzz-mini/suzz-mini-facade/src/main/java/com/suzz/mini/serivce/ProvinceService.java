package com.suzz.mini.serivce;

import com.suzz.mini.domain.condition.ProvinceCondition;
import com.suzz.mini.domain.organization.Province;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 15:44
 **/
public interface ProvinceService {

    List<Province> queryAll(ProvinceCondition provinceCondition);

    /**
     * 6位字符查询名称
     * @param code
     * @return
     */
    String queryNameByCode(String code);
}
