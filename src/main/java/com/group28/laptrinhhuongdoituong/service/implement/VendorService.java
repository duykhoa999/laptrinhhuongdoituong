package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  private final VendorRepository vendorRepository;
  @Autowired
  private VendorConverter vendorConverter;

  @Override
  public VendorEntity save(VendorDTO vendorDTO) {
    return vendorRepository.save(vendorConverter.toEntity(vendorDTO));
  }

  @Override
  public List<VendorEntity> listVendor() {
    List<VendorEntity> list = vendorRepository.findAll();
    // List<VendorDTO> listDTO = new ArrayList<>();
    // for (VendorEntity item : list) {
    //   if (!BooleanUtils.isTrue(item.getDeleted())) {
    //     VendorDTO dto = vendorConverter.toDTO(item);
    //     listDTO.add(dto);
    //   }
    // }
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(VendorDTO vendorDTO) {
    vendorRepository.delete(vendorConverter.toEntity(vendorDTO));
  }

  @Override
  public VendorEntity findVendorById(Long id) {
    if (vendorRepository.findById(id).isEmpty()) {
      return null;
    }
    return vendorRepository.findById(id).get();
  }

  @Override
  public VendorEntity update(VendorDTO vendorDTO) {
    return vendorRepository.save(vendorConverter.toEntity(vendorDTO));
  }

  @Override
  public List<VendorEntity> listVendor(String keyWord) {
    List<VendorEntity> list = vendorRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

}
