package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;

public interface IVendorOrderService {
  VendorOrderEntity save(VendorOrderDTO vendorOrderDTO);
  List<VendorOrderEntity> listVendorOrder();
  List<VendorOrderEntity> listVendorOrder(String keyWord);
  void delete(VendorOrderDTO productDTO);
  VendorOrderEntity findVendorOrderById(Long id);
  VendorOrderEntity update(VendorOrderDTO vendorOrderDTO);
}
