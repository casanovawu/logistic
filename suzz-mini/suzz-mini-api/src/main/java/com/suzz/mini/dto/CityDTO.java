package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 17:16
 **/
@Data
public class CityDTO implements Serializable {

    private static final long serialVersionUID = 4285709074710447093L;

    private Integer id;

    private Integer code;

    private String name;

    private List<AreaDTO> areaList;
}
