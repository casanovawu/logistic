package com.suzz.mini.serivce.impl;

import com.suzz.mini.domain.Dictionary;
import com.suzz.mini.domain.condition.DictionaryCondition;
import com.suzz.mini.mapper.DictionaryMapper;
import com.suzz.mini.serivce.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/18 23:21
 **/
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> queryList(DictionaryCondition dictionaryCondition) {
        return dictionaryMapper.queryList(dictionaryCondition);
    }
}
