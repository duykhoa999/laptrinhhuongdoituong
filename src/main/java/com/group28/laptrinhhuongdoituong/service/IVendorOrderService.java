package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;

public interface IVendorOrderService {
  VendorOrderEntity save(VendorOrderDTO staffDTO);
  List<VendorOrderEntity> listStaff();
  List<VendorOrderEntity> listStaff(String keyWord);
  void delete(VendorOrderDTO productDTO);
  VendorOrderEntity findVendorOrderById(Long id);
  VendorOrderEntity update(VendorOrderDTO productDTO);
}
