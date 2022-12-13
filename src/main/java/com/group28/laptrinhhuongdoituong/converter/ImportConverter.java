package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.service.implement.ImportService;
import com.group28.laptrinhhuongdoituong.service.implement.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportConverter {
    @Autowired
    private static StaffService staffService;

    public static ImportDTO toDTO(ImportEntity importEntity) {
        ImportDTO importDTO = new ImportDTO();
        importDTO.setId(importEntity.getId());
        importDTO.setDate(importEntity.getDate());
        importDTO.setStaff_id(importEntity.getStaff().getId());
        importDTO.setVendor_order_id(importEntity.getVendor_order_id());
        importDTO.setDeleted(importEntity.getDeleted());

        return importDTO;
    }

    public static ImportEntity toEntity(ImportDTO importDTO) {
        ImportEntity importEntity = new ImportEntity();
        importEntity.setId(importDTO.getId());
        importEntity.setDate(importDTO.getDate());
        importEntity.setStaff(staffService.findStaffById(importDTO.getStaff_id()));
        importEntity.setVendor_order_id(importDTO.getVendor_order_id());
        importEntity.setDeleted(importDTO.getDeleted());

        return importEntity;
    }
}
