package com.suzz.mini.convertor;

import cn.hutool.core.collection.CollUtil;
import com.suzz.mini.dto.AreaDTO;
import com.suzz.mini.dto.CityDTO;
import com.suzz.mini.dto.ProvinceDTO;
import com.suzz.mini.dto.ProvinceQueryDTO;
import com.suzz.mini.vo.OrganizationInfoVO;
import com.suzz.mini.vo.OrganizationQueryVO;
import com.suzz.platform.vo.response.ListResponse;
import com.suzz.platform.vo.response.SimpleResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author subo
 * @date 2022/5/15 18:19
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrganizationConvertor {

    public static ProvinceQueryDTO convertorToProvinceQueryDTO(OrganizationQueryVO organizationQueryVO){
        ProvinceQueryDTO provinceQueryDTO = new ProvinceQueryDTO();
        provinceQueryDTO.setLang(organizationQueryVO.getLang());
        return provinceQueryDTO;
    }

    public static SimpleResponse<OrganizationInfoVO> convertorToOrganizationInfoVO(ListResponse<ProvinceDTO> response){
        SimpleResponse<OrganizationInfoVO> simpleResponse=new SimpleResponse<>();
        if(CollUtil.isNotEmpty(response.getData())){
            OrganizationInfoVO organizationInfoVO=new OrganizationInfoVO();
            simpleResponse.setData(organizationInfoVO);
            Map<Integer,String> province_list=new HashMap<>();
            Map<Integer,String> city_list=new HashMap<>();
            Map<Integer,String> county_list=new HashMap<>();
            organizationInfoVO.setProvince_list(province_list);
            organizationInfoVO.setCity_list(city_list);
            organizationInfoVO.setCounty_list(county_list);

            List<ProvinceDTO> data = response.getData();
            for (ProvinceDTO provinceDTO : data) {
                int provinceCode = provinceDTO.getId() * 10000;
                province_list.put(provinceCode,provinceDTO.getName());
                if(CollUtil.isNotEmpty(provinceDTO.getCityList())){
                    for (CityDTO cityDTO : provinceDTO.getCityList()) {
                        int cityCode = provinceCode+cityDTO.getCode() * 100;
                        city_list.put(cityCode,cityDTO.getName());
                        if(CollUtil.isNotEmpty(cityDTO.getAreaList())){
                            for (AreaDTO areaDTO : cityDTO.getAreaList()) {
                                int areaCode = cityCode+areaDTO.getCode();
                                county_list.put(areaCode,areaDTO.getName());
                            }
                        }
                    }
                }
            }
        }
        return simpleResponse;
    }
}
