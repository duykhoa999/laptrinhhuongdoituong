package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.ImportDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailKey;
import com.group28.laptrinhhuongdoituong.repository.ImportDetailRepository;
import com.group28.laptrinhhuongdoituong.service.IImportDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ImportDetailService implements IImportDetailService {

  @Autowired
  private ImportDetailRepository importDetailRepository;

  @Autowired
  private ImportDetailConverter importDetailConverter;

  @Override
  public ImportDetailEntity save(ImportDetailDTO importDetailDTO) {
    return importDetailRepository.save(importDetailConverter.toEntity(importDetailDTO));
  }

  @Override
  public List<ImportDetailEntity> listImportDetail() {
    List<ImportDetailEntity> list = importDetailRepository.findAll();
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public List<ImportDetailEntity> listImportDetail(String keyWord) {
    List<ImportDetailEntity> list = importDetailRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(ImportDetailDTO importDetailDTO) {
    importDetailRepository.delete(importDetailConverter.toEntity(importDetailDTO));
  }

  @Override
  public ImportDetailEntity findImportDetailById(ImportDetailKey id) {
    if (importDetailRepository.findById(id).isEmpty()) {
      return null;
    }
    return importDetailRepository.findById(id).get();
  }

}
