package com.suzz.mini.convert;

import com.suzz.mini.domain.OrderAudit;
import com.suzz.mini.dto.mgt.OrderAuditDTO;
import org.springframework.beans.BeanUtils;

public class OrderAuditConvert {

    public static OrderAudit dtoToEntity(OrderAuditDTO dto) {
        OrderAudit entity = new OrderAudit();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static OrderAuditDTO entityToDTO(OrderAudit entity) {
        OrderAuditDTO dto = new OrderAuditDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
