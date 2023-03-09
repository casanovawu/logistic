package com.suzz.mini.domain;


import com.suzz.mini.dto.DictionaryDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * dictionary
 * @author 
 */
@Data
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 6106496040069470666L;

    private Integer id;

    private Integer key;

    /**
     * code
     */
    private String code;

    private DictionaryLang dictionaryLang;

    public DictionaryDTO toDictionaryDTO(){
        DictionaryDTO dictionaryDTO=new DictionaryDTO();
        dictionaryDTO.setKey(this.key);
        if(Objects.nonNull(dictionaryLang)){
            dictionaryDTO.setName(dictionaryLang.getName());
        }
        return dictionaryDTO;
    }

}