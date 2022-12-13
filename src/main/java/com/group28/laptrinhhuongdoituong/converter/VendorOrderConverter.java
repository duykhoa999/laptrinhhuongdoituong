package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;
import com.group28.laptrinhhuongdoituong.service.implement.UserService;
import com.group28.laptrinhhuongdoituong.service.implement.VendorService;

@Component
public class VendorOrderConverter  {
  @Autowired
  private VendorService vendorService;

  @Autowired
  private UserService userService;

  public VendorOrderDTO toDTO(VendorOrderEntity vendorOrderEntity) {
    VendorOrderDTO vendorOrderDTO = new VendorOrderDTO();
    vendorOrderDTO.setId(vendorOrderEntity.getId());
    vendorOrderDTO.setCode(vendorOrderEntity.getCode());
    vendorOrderDTO.setDate(vendorOrderEntity.getDate());
    vendorOrderDTO.setVendor_id(vendorOrderEntity.getVendor().getId());
    vendorOrderDTO.setUser_id(vendorOrderEntity.getUser().getId());
    vendorOrderDTO.setDeleted(vendorOrderEntity.getDeleted());
    return vendorOrderDTO;
  }

  public VendorOrderEntity toEntity(VendorOrderDTO vendorOrderDTO) {
    VendorOrderEntity vendorOrderEntity = new VendorOrderEntity();
    vendorOrderEntity.setId(vendorOrderDTO.getId());
    vendorOrderEntity.setCode(vendorOrderDTO.getCode());
    vendorOrderEntity.setDate(vendorOrderDTO.getDate());
    vendorOrderEntity.setVendor(vendorService.findVendorById(vendorOrderDTO.getVendor_id()));
    vendorOrderEntity.setUser(userService.findUserById(vendorOrderDTO.getUser_id()));
    vendorOrderEntity.setDeleted(vendorOrderDTO.getDeleted());
    return vendorOrderEntity;
  }
}
