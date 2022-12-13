package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;

@Component
public class VendorConverter {
  public static VendorDTO toDTO(VendorEntity vendorEntity) {
    VendorDTO vendorDTO = new VendorDTO();
    vendorDTO.setId(vendorEntity.getId());
    vendorDTO.setName(vendorEntity.getName());
    vendorDTO.setAddress(vendorEntity.getAddress());
    vendorDTO.setEmail(vendorEntity.getEmail());
    vendorDTO.setDeleted(vendorEntity.getDeleted());
    return vendorDTO;
  }

  public static VendorEntity toEntity(VendorDTO productDTO) {
    VendorEntity vendorEntity = new VendorEntity();
    vendorEntity.setId(productDTO.getId());
    vendorEntity.setName(productDTO.getName());
    vendorEntity.setAddress(productDTO.getAddress());
    vendorEntity.setEmail(productDTO.getEmail());
    vendorEntity.setDeleted(productDTO.getDeleted());
    return vendorEntity;
  }
}
