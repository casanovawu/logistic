package com.suzz.mini.convertor;

import com.suzz.mini.dto.DictionaryDTO;
import com.suzz.mini.vo.DictionaryVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author subo
 * @date 2022/5/19 13:52
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DictionaryConvertor {

    public static DictionaryVO convertorToDictionaryVO(DictionaryDTO dictionaryDTO){
        DictionaryVO dictionaryVO = new DictionaryVO();
        dictionaryVO.setKey(dictionaryDTO.getKey());
        dictionaryVO.setName(dictionaryDTO.getName());
        return dictionaryVO;
    }
}
