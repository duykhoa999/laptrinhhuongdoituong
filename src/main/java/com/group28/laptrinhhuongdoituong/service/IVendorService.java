package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;

public interface IVendorService {
  VendorEntity save(VendorDTO vendorDTO);

  List<VendorDTO> listVendor();

  void delete(VendorDTO vendorDTO);

  VendorDTO findVendorById(Long id);

  VendorEntity update(VendorDTO vendorDTO);
}
