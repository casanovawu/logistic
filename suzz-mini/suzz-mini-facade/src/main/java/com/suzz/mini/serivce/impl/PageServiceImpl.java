package com.suzz.mini.serivce.impl;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.domain.PageModule;
import com.suzz.mini.domain.PageModuleLang;
import com.suzz.mini.domain.condition.PageModuleCondition;
import com.suzz.mini.domain.condition.PageModuleLangCondition;
import com.suzz.mini.mapper.PageModuleLangMapper;
import com.suzz.mini.mapper.PageModuleMapper;
import com.suzz.mini.serivce.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author subo
 * @date 2022/5/15 19:41
 **/
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageModuleMapper pageModuleMapper;

    @Autowired
    private PageModuleLangMapper pageModuleLangMapper;

    @Override
    public List<PageModule> queryPageModuleList(PageModuleCondition pageModuleCondition) {
        List<PageModule> pageModules = pageModuleMapper.queryList(pageModuleCondition);
        if(CollUtil.isNotEmpty(pageModules)){
            for (PageModule pageModule : pageModules) {
                PageModuleLangCondition condition = PageModuleLangCondition.builder().pageModuleId(pageModule.getId()).lang(pageModuleCondition.getLang()).build();
                PageModuleLang pageModuleLang = pageModuleLangMapper.queryInfo(condition);
                if(Objects.nonNull(pageModuleLang)){
                    pageModule.setPageModuleLang(pageModuleLang);
                }
            }
        }
        return pageModules;
    }
}
