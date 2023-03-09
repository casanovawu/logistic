package com.suzz.mini.domain.condition;

import com.suzz.mini.dto.ProvinceQueryDTO;
import lombok.Data;

/**
 * @author subo
 * @date 2022/5/15 16:01
 **/
@Data
public class ProvinceCondition {

    private Integer id;

    private String lang;

    public static ProvinceCondition toProvinceCondition(ProvinceQueryDTO provinceQueryDTO){
        ProvinceCondition provinceCondition = new ProvinceCondition();
        provinceCondition.setLang(provinceQueryDTO.getLang());
        return provinceCondition;
    }
}
