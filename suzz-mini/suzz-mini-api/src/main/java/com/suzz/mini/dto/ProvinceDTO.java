package com.suzz.mini.dto;

import com.suzz.mini.annotation.Dic;
import com.suzz.mini.annotation.DicMark;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 17:08
 **/
@Data
@DicMark
public class ProvinceDTO implements Serializable {

    private static final long serialVersionUID = 5024636466161547869L;

    private Integer id;

    @Dic
    private String name;

    private List<CityDTO> cityList;
}
