package com.suzz.mini.domain.condition;


import lombok.Builder;
import lombok.Data;

/**
 * page
 * @author 
 */
@Builder
@Data
public class PageModuleLangCondition {

    private Integer pageModuleId;

    private String lang;
}