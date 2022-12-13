package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.service.implement.UserService;
import com.group28.laptrinhhuongdoituong.service.implement.VendorOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportConverter {
    @Autowired
    private UserService userService;

    @Autowired
    private VendorOrderService vendorOrderService;

    public ImportDTO toDTO(ImportEntity importEntity) {
        ImportDTO importDTO = new ImportDTO();
        importDTO.setId(importEntity.getId());
        importDTO.setCode(importEntity.getCode());
        importDTO.setDate(importEntity.getDate());
        importDTO.setUser_id(importEntity.getUser().getId());
        importDTO.setVendor_order_id(importEntity.getVendorOrder().getId());
        importDTO.setDeleted(importEntity.getDeleted());

        return importDTO;
    }

    public ImportEntity toEntity(ImportDTO importDTO) {
        ImportEntity importEntity = new ImportEntity();
        importEntity.setId(importDTO.getId());
        importEntity.setCode(importDTO.getCode());
        importEntity.setDate(importDTO.getDate());
        importEntity.setUser(userService.findUserById(importDTO.getUser_id()));
        importEntity.setVendorOrder(vendorOrderService.findVendorOrderById(importDTO.getVendor_order_id()));
        importEntity.setDeleted(importDTO.getDeleted());

        return importEntity;
    }
}
