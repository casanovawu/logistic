package com.suzz.mini.domain;


import com.suzz.mini.dto.PageModuleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * page_module
 * @author 
 */
@Data
public class PageModule  implements Serializable {

    private static final long serialVersionUID = 3525772359229408443L;

    private Integer id;

    /**
     * 页面id
     */
    private Integer fkPage;

    /**
     * code
     */
    private String code;

    private PageModuleLang pageModuleLang;

    public PageModuleDTO toPageModuleDTO(){
        PageModuleDTO pageModuleDTO=new PageModuleDTO();
        pageModuleDTO.setCode(code);
        if(Objects.nonNull(pageModuleLang)){
            pageModuleDTO.setName(pageModuleLang.getName());
        }
        return pageModuleDTO;
    }
}