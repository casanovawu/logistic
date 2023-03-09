package com.suzz.mini.serivce;

import com.suzz.mini.domain.PageModule;
import com.suzz.mini.domain.condition.PageModuleCondition;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/15 19:40
 **/
public interface PageService {

    List<PageModule> queryPageModuleList(PageModuleCondition pageModuleCondition);
}
