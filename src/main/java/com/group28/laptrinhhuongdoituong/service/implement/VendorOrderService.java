package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;
import com.group28.laptrinhhuongdoituong.service.IVendorOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VendorOrderService implements IVendorOrderService {

  @Override
  public VendorOrderEntity save(VendorOrderDTO staffDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<VendorOrderEntity> listStaff() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<VendorOrderEntity> listStaff(String keyWord) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(VendorOrderDTO productDTO) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public VendorOrderEntity findVendorOrderById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public VendorOrderEntity update(VendorOrderDTO productDTO) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
