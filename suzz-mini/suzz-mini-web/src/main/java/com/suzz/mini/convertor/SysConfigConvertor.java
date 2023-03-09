package com.suzz.mini.convertor;

import cn.hutool.core.collection.CollectionUtil;
import com.suzz.mini.dto.SysConfigDTO;
import com.suzz.mini.dto.SysConfigDeleteDTO;
import com.suzz.mini.dto.SysConfigQueryDTO;
import com.suzz.mini.vo.SysConfigDeleteVO;
import com.suzz.mini.vo.SysConfigQueryResultVO;
import com.suzz.mini.vo.SysConfigQueryVO;
import com.suzz.mini.vo.SysConfigVO;
import com.suzz.platform.vo.response.ListResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author subo
 * @date 2022/8/22 22:18
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SysConfigConvertor {

    public static SysConfigQueryDTO convertorSysConfigQueryDTO(SysConfigQueryVO sysConfigQueryVO){
        SysConfigQueryDTO sysConfigQueryDTO = new SysConfigQueryDTO();
        sysConfigQueryDTO.setKeyList(sysConfigQueryVO.getKeyList());
        return sysConfigQueryDTO;
    }

    public static SysConfigQueryResultVO convertorSysConfigQueryResultVO(ListResponse<SysConfigDTO> response){
        if(CollectionUtil.isNotEmpty(response.getData())){
            SysConfigQueryResultVO sysConfigVO=new SysConfigQueryResultVO();
            Map<String,String> map=new HashMap<>();
            for (SysConfigDTO datum : response.getData()) {
                map.put(datum.getParamKey(),datum.getParamValue());
            }
            sysConfigVO.setSysConfigMap(map);
            return sysConfigVO;
        }
      return null;
    }

    public static SysConfigDTO convertorSysConfigDTO(SysConfigVO sysConfigVO){
        SysConfigDTO sysConfigDTO = new SysConfigDTO();
        sysConfigDTO.setId(sysConfigVO.getId());
        sysConfigDTO.setParamKey(sysConfigVO.getParamKey());
        sysConfigDTO.setParamValue(sysConfigVO.getParamValue());
        sysConfigDTO.setRemark(sysConfigVO.getRemark());
        return sysConfigDTO;
    }

    public static SysConfigDeleteDTO convertorSysConfigDeleteDTO(SysConfigDeleteVO sysConfigDeleteVO){
        SysConfigDeleteDTO sysConfigDeleteDTO = new SysConfigDeleteDTO();
        sysConfigDeleteDTO.setParamKey(sysConfigDeleteVO.getParamKey());
        return sysConfigDeleteDTO;
    }
}
