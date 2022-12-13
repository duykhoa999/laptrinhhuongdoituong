package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
import com.group28.laptrinhhuongdoituong.service.implement.ImportService;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;

@Component
public class ImportDetailConverter {

  @Autowired
  private ImportService importService;

  @Autowired
  private ProductService productService;

  public ImportDetailDTO toDTO(ImportDetailEntity importDetailEntity) {
    ImportDetailDTO importDetailDTO = new ImportDetailDTO();
    importDetailDTO.setImport_id(importDetailEntity.getImport_id().getId());
    importDetailDTO.setProduct_id(importDetailEntity.getProduct_id().getId());
    importDetailDTO.setAmount(importDetailEntity.getAmount());
    importDetailDTO.setPrice(importDetailEntity.getPrice());
    importDetailDTO.setDeleted(importDetailEntity.getDeleted());

    return importDetailDTO;
  }

  public ImportDetailEntity toEntity(ImportDetailDTO importDetailDTO) {
    ImportDetailEntity importDetailEntity = new ImportDetailEntity();
    importDetailEntity.setImport_id(importService.findImportById(importDetailDTO.getImport_id()));
    importDetailEntity.setProduct_id(productService.findProductById(importDetailDTO.getProduct_id()));
    importDetailEntity.setAmount(importDetailDTO.getAmount());
    importDetailEntity.setPrice(importDetailDTO.getPrice());
    importDetailEntity.setDeleted(importDetailDTO.getDeleted());

    return importDetailEntity;
  }
}
