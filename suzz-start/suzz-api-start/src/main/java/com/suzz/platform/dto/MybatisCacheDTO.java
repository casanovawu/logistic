package com.suzz.platform.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author subo
 * @date 2022/8/14 10:38
 **/
@Data
public class MybatisCacheDTO implements Serializable {

    private static final long serialVersionUID = 6885179236288777797L;

    private String cacheId;
}
