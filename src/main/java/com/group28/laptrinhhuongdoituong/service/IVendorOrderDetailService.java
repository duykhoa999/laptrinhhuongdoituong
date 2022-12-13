package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailKey;

public interface IVendorOrderDetailService {
  VendorOrderDetailEntity save(VendorOrderDetailDTO vendorOrderDetailDTO);
  List<VendorOrderDetailEntity> listVendorOrderDetail();
  List<VendorOrderDetailEntity> listVendorOrderDetail(String keyWord);
  void delete(VendorOrderDetailDTO vendorOrderDetailDTO);
  VendorOrderDetailEntity findVendorOrderDetailById(VendorOrderDetailKey id);
  VendorOrderDetailEntity update(VendorOrderDetailDTO vendorOrderDetailDTO);
}
