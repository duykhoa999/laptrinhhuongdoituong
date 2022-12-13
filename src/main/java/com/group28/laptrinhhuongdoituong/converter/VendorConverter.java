package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;

@Component
public class VendorConverter {
  public VendorDTO toDTO(VendorEntity vendorEntity) {
    VendorDTO vendorDTO = new VendorDTO();
    vendorDTO.setId(vendorEntity.getId());
    vendorDTO.setFirst_name(vendorEntity.getFirst_name());
    vendorDTO.setLast_name(vendorEntity.getLast_name());
    vendorDTO.setAddress(vendorEntity.getAddress());
    vendorDTO.setEmail(vendorEntity.getEmail());
    vendorDTO.setDeleted(vendorEntity.getDeleted());
    return vendorDTO;
  }

  public VendorEntity toEntity(VendorDTO vendorDTO) {
    VendorEntity vendorEntity = new VendorEntity();
    vendorEntity.setId(vendorDTO.getId());
    vendorEntity.setFirst_name(vendorDTO.getFirst_name());
    vendorEntity.setLast_name(vendorDTO.getLast_name());
    vendorEntity.setAddress(vendorDTO.getAddress());
    vendorEntity.setEmail(vendorDTO.getEmail());
    vendorEntity.setDeleted(vendorDTO.getDeleted());
    return vendorEntity;
  }
}
