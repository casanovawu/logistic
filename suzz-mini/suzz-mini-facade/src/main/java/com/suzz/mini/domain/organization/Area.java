package com.suzz.mini.domain.organization;


import com.suzz.mini.dto.AreaDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * area
 * @author 
 */
@Data
public class Area  implements Serializable {

    private static final long serialVersionUID = -5286548670765817967L;

    private Integer id;

    /**
     * 区域编码
     */
    private Integer code;

    /**
     * 城市id
     */
    private Integer fkCity;

    private AreaLang areaLang;

    public AreaDTO toAreaDTO(){
        AreaDTO areaDTO=new AreaDTO();
        areaDTO.setId(id);
        areaDTO.setCode(code);
        if(Objects.nonNull(areaLang)){
            areaDTO.setName(areaLang.getName());
        }
        return areaDTO;
    }

}