package com.suzz.mini.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2023/1/4 21:59
 **/
@Data
public class AgreementDTO implements Serializable {

    private static final long serialVersionUID = 6858894655775012981L;

    private String name;

    private String text;
}
