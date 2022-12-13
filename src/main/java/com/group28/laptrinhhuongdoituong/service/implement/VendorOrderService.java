package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.VendorOrderConverter;
import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;
import com.group28.laptrinhhuongdoituong.repository.VendorOrderRepository;
import com.group28.laptrinhhuongdoituong.service.IVendorOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VendorOrderService implements IVendorOrderService {

  @Autowired
  private VendorOrderRepository vendorOrderRepository;

  @Autowired
  private VendorOrderConverter vendorOrderConverter;

  @Override
  public VendorOrderEntity save(VendorOrderDTO vendorOrderDTO) {
    return vendorOrderRepository.save(vendorOrderConverter.toEntity(vendorOrderDTO));
  }

  @Override
  public List<VendorOrderEntity> listVendorOrder() {
    List<VendorOrderEntity> list = vendorOrderRepository.findAll();
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public List<VendorOrderEntity> listVendorOrder(String keyWord) {
    List<VendorOrderEntity> list = vendorOrderRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(VendorOrderDTO productDTO) {
    vendorOrderRepository.delete(vendorOrderConverter.toEntity(productDTO));
  }

  @Override
  public VendorOrderEntity findVendorOrderById(Long id) {
    if (vendorOrderRepository.findById(id).isEmpty()) {
      return null;
    }
    return vendorOrderRepository.findById(id).get();
  }

  @Override
  public VendorOrderEntity update(VendorOrderDTO vendorOrderDTO) {
    return vendorOrderRepository.save(vendorOrderConverter.toEntity(vendorOrderDTO));
  }
  
}
