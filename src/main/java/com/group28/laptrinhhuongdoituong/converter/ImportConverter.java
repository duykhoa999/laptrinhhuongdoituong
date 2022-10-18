package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import org.springframework.stereotype.Component;

@Component
public class ImportConverter {
    public ImportDTO toDTO(ImportEntity importEntity) {
        ImportDTO importDTO = new ImportDTO();
        importDTO.setId(importEntity.getId());
        importDTO.setDate(importEntity.getDate());
        importDTO.setStaff_id(importEntity.getStaff_id());
        importDTO.setVendor_order_id(importEntity.getVendor_order_id());
        importDTO.setDeleted(importEntity.getDeleted());

        return importDTO;
    }

    public ImportEntity toEntity(ImportDTO importDTO) {
        ImportEntity importEntity = new ImportEntity();
        importEntity.setId(importDTO.getId());
        importEntity.setDate(importDTO.getDate());
        importEntity.setStaff_id(importDTO.getStaff_id());
        importEntity.setVendor_order_id(importDTO.getVendor_order_id());
        importEntity.setDeleted(importDTO.getDeleted());

        return importEntity;
    }
}
