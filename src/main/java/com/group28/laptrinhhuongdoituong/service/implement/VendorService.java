package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.controller.VendorController;
import com.group28.laptrinhhuongdoituong.converter.VendorConverter;
import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;
import com.group28.laptrinhhuongdoituong.repository.VendorRepository;
import com.group28.laptrinhhuongdoituong.service.IVendorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VendorService implements IVendorService {

  @Autowired
  private final VendorConverter vendorConverter;

  @Autowired
  private final VendorRepository vendorRepository;

  @Override
  public VendorEntity save(VendorDTO vendorDTO) {
    return vendorRepository.save(vendorConverter.toEntity(vendorDTO));
  }

  @Override
  public List<VendorDTO> listVendor() {
    List<VendorEntity> list = vendorRepository.findAll();
    List<VendorDTO> listDTO = new ArrayList<>();
    for (VendorEntity item : list) {
      if (!BooleanUtils.isTrue(item.getDeleted())) {
        VendorDTO dto = vendorConverter.toDTO(item);
        listDTO.add(dto);
      }
    }
    return listDTO;
  }

  @Override
  public void delete(VendorDTO vendorDTO) {
    vendorRepository.delete(vendorConverter.toEntity(vendorDTO));
  }

  @Override
  public VendorDTO findVendorById(Long id) {
    VendorDTO vendorDTO = null;
    if (vendorRepository.findById(id).isEmpty()) {
      return vendorDTO;
    }
    vendorDTO = vendorConverter.toDTO(vendorRepository.findById(id).get());
    return vendorDTO;
  }

  @Override
  public VendorEntity update(VendorDTO vendorDTO) {
    return vendorRepository.save(vendorConverter.toEntity(vendorDTO));
  }

}
