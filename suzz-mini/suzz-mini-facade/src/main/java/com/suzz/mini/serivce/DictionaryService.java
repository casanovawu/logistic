package com.suzz.mini.serivce;

import com.suzz.mini.domain.Dictionary;
import com.suzz.mini.domain.condition.DictionaryCondition;

import java.util.List;

/**
 * @author subo
 * @date 2022/5/18 23:14
 **/
public interface DictionaryService {

   List<Dictionary> queryList(DictionaryCondition dictionaryCondition);
}
