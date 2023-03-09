package com.suzz.mini.convertor;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.PageModuleDTO;
import com.suzz.mini.dto.PageModuleQueryDTO;
import com.suzz.mini.vo.PageModuleMapVO;
import com.suzz.mini.vo.PageModuleQueryVO;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author subo
 * @date 2022/5/15 19:14
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageConvertor {

    public static PageModuleQueryDTO convertorToPageModuleQueryDTO(PageModuleQueryVO pageModuleQueryVO){
        PageModuleQueryDTO pageModuleQueryDTO = new PageModuleQueryDTO();
        pageModuleQueryDTO.setPageId(pageModuleQueryVO.getPageId());
        return pageModuleQueryDTO;
    }

    public static SimpleResponse<PageModuleMapVO> convertorToPageModuleMapVO(ListResponse<PageModuleDTO> listResponse){
        SimpleResponse<PageModuleMapVO> simpleResponse=new SimpleResponse<>();
        if(CollUtil.isNotEmpty(listResponse.getData())){
            PageModuleMapVO pageModuleMapVO=new PageModuleMapVO();
            simpleResponse.setData(pageModuleMapVO);
            Map<String,String> pageModuleMap=new HashMap<>();
            pageModuleMapVO.setPageModuleMap(pageModuleMap);
            for (PageModuleDTO pageModuleDTO : listResponse.getData()) {
                pageModuleMap.put(pageModuleDTO.getCode(),pageModuleDTO.getName());
            }
        }
        return simpleResponse;
    }
}
