package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.VendorOrderDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.VendorOrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailKey;
import com.group28.laptrinhhuongdoituong.repository.VendorOrderDetailRepository;
import com.group28.laptrinhhuongdoituong.service.IVendorOrderDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VendorOrderDetailService implements IVendorOrderDetailService {

  @Autowired
  private VendorOrderDetailRepository vendorOrderDetailRepository;

  @Autowired
  private VendorOrderDetailConverter vendorOrderDetailConverter;

  @Override
  public VendorOrderDetailEntity save(VendorOrderDetailDTO vendorOrderDetailDTO) {
    return vendorOrderDetailRepository.save(vendorOrderDetailConverter.toEntity(vendorOrderDetailDTO));
  }

  @Override
  public List<VendorOrderDetailEntity> listVendorOrderDetail() {
    List<VendorOrderDetailEntity> list = vendorOrderDetailRepository.findAll();
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public List<VendorOrderDetailEntity> listVendorOrderDetail(String keyWord) {
    List<VendorOrderDetailEntity> list = vendorOrderDetailRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(VendorOrderDetailDTO vendorOrderDetailDTO) {
    vendorOrderDetailRepository.delete(vendorOrderDetailConverter.toEntity(vendorOrderDetailDTO));
  }

  @Override
  public VendorOrderDetailEntity findVendorOrderDetailById(VendorOrderDetailKey id) {
    if (vendorOrderDetailRepository.findById(id).isEmpty()) {
      return null;
    }
    return vendorOrderDetailRepository.findById(id).get();
  }

  @Override
  public VendorOrderDetailEntity update(VendorOrderDetailDTO vendorOrderDetailDTO) {
    return vendorOrderDetailRepository.save(vendorOrderDetailConverter.toEntity(vendorOrderDetailDTO));
  }
  
}
