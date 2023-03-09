package com.suzz.mini.convert;

import com.suzz.mini.domain.Order;
import com.suzz.mini.domain.OrderAudit;
import com.suzz.mini.domain.OrderCarType;
import com.suzz.mini.dto.mgt.AuditMgtDTO;
import com.suzz.mini.dto.mgt.CarTypeMgtDTO;
import com.suzz.mini.dto.mgt.OrderMgtDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderConvert {

    public static Order dtoToEntity(OrderMgtDTO dto) {
        Order entity = new Order();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static OrderMgtDTO entityToDTO(Order entity) {
        OrderMgtDTO dto = new OrderMgtDTO();
        BeanUtils.copyProperties(entity, dto);
        if(Objects.nonNull(entity.getMiniUser())){
            dto.setUserName(entity.getMiniUser().getUserName());
        }
        return dto;
    }

    public static OrderMgtDTO setCar(OrderMgtDTO dto, List<OrderCarType> list) {
        if (CollectionUtils.isEmpty(list)) {
            return dto;
        }
        List<CarTypeMgtDTO> collect = list.stream().map(a -> {
            CarTypeMgtDTO carTypeMgtDTO = new CarTypeMgtDTO();
            BeanUtils.copyProperties(a, carTypeMgtDTO);
            return carTypeMgtDTO;
        }).collect(Collectors.toList());
        dto.setCarList(collect);
        return dto;
    }

    public static OrderMgtDTO setAudit(OrderMgtDTO dto, List<OrderAudit> list) {
        if (CollectionUtils.isEmpty(list)) {
            return dto;
        }
        List<AuditMgtDTO> collect = list.stream().map(a -> {
            AuditMgtDTO auditMgtDTO = new AuditMgtDTO();
            BeanUtils.copyProperties(a, auditMgtDTO);
            return auditMgtDTO;
        }).collect(Collectors.toList());
        dto.setAuditList(collect);
        return dto;
    }
}
