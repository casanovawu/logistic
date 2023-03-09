package com.suzz.mini.domain.organization;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.CityDTO;
import com.suzz.mini.dto.ProvinceDTO;
import lombok.Data;

/**
 * province
 * @author 
 */
@Data
public class Province  implements Serializable {

    private static final long serialVersionUID = -7022789175822470967L;

    private Integer id;

    private ProvinceLang provinceLang;

    private List<City> cityList;

    public ProvinceDTO toProvinceDTO(){
        ProvinceDTO provinceDTO=new ProvinceDTO();
        provinceDTO.setId(id);
        if(Objects.nonNull(provinceLang)){
            provinceDTO.setName(provinceLang.getName());
        }
        if(CollUtil.isNotEmpty(cityList)){
            List<CityDTO> cityDTOList = cityList.stream().map(City::toCityDTO).collect(Collectors.toList());
            provinceDTO.setCityList(cityDTOList);
        }
        return provinceDTO;
    }

}