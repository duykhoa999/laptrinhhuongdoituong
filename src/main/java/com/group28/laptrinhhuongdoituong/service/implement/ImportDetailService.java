package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.ImportDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
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
    return null;
  }

  @Override
  public List<ImportDetailEntity> listImportDetail(String keyWord) {
    return null;
  }

  @Override
  public void delete(ImportDetailDTO importDetailDTO) {
    
  }

  @Override
  public ImportDetailEntity findImportDetailById(Long id) {
    return null;
  }
  
}
