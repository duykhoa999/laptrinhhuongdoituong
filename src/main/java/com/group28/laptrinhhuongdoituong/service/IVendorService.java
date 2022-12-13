package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;

public interface IVendorService {
  VendorEntity save(VendorDTO vendorDTO);
  List<VendorEntity> listVendor();
  List<VendorEntity> listVendor(String keyWord);
  void delete(VendorDTO vendorDTO);
  VendorEntity findVendorById(Long id);
  VendorEntity update(VendorDTO vendorDTO);
}
