package com.suzz.mini.domain.condition;


import com.suzz.mini.dto.PageModuleQueryDTO;
import com.suzz.platform.util.LangContent;
import lombok.Data;

/**
 * page
 * @author 
 */
@Data
public class PageModuleCondition {

    private Integer pageId;

    private String lang;

    public static PageModuleCondition toPageModuleCondition(PageModuleQueryDTO pageModuleQueryDTO){
        PageModuleCondition pageModuleCondition = new PageModuleCondition();
        pageModuleCondition.setPageId(pageModuleQueryDTO.getPageId());
        pageModuleCondition.setLang(LangContent.getLang());
        return pageModuleCondition;
    }
}