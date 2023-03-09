package com.suzz.mini.facade.impl;

import com.suzz.mini.domain.Dictionary;
import com.suzz.mini.domain.condition.DictionaryCondition;
import com.suzz.mini.dto.DictionaryDTO;
import com.suzz.mini.facade.DictionaryFacade;
import com.suzz.mini.serivce.DictionaryService;
import com.suzz.platform.util.FacadeConvertUtil;
import com.suzz.platform.util.LangContent;
import com.suzz.platform.vo.request.SimpleRequest;
import com.suzz.platform.vo.response.ListResponse;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/19 13:55
 **/
@DubboService(interfaceClass = DictionaryFacade.class)
@Api(tags = "dictionaryFacadeImpl")
public class DictionaryFacadeImpl implements DictionaryFacade {

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public ListResponse<DictionaryDTO> queryList(SimpleRequest<String> code) {
        DictionaryCondition dictionaryCondition=new DictionaryCondition();
        dictionaryCondition.setLang(LangContent.getLang());
        dictionaryCondition.setCode(code.getReqDtos());
        List<Dictionary> dictionaries = dictionaryService.queryList(dictionaryCondition);
        return FacadeConvertUtil.successForList(dictionaries,Dictionary::toDictionaryDTO);
    }
}
