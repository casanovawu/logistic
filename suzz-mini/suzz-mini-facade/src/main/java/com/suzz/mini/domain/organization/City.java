package com.suzz.mini.domain.organization;


import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.AreaDTO;
import com.suzz.mini.dto.CityDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * city
 * @author 
 */
@Data
public class City  implements Serializable {

    private static final long serialVersionUID = 8726278052615926820L;

    private Integer id;

    /**
     * 城市code
     */
    private Integer code;

    /**
     * 省份id
     */
    private Integer fkProvince;

    /**
     * 城市lang
     */
    private CityLang cityLang;

    private List<Area> areaList;

    public CityDTO toCityDTO(){
        CityDTO cityDTO=new CityDTO();
        cityDTO.setId(id);
        cityDTO.setCode(code);
        if(Objects.nonNull(cityLang)){
            cityDTO.setName(cityLang.getName());
        }
        if(CollUtil.isNotEmpty(areaList)){
            List<AreaDTO> areaDTOList = areaList.stream().map(Area::toAreaDTO).collect(Collectors.toList());
            cityDTO.setAreaList(areaDTOList);
        }
        return cityDTO;
    }


}