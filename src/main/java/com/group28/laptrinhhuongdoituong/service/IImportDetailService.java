package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;

public interface IImportDetailService {
  ImportDetailEntity save(ImportDetailDTO importDetailDTO);
  List<ImportDetailEntity> listImportDetail();
  List<ImportDetailEntity> listImportDetail(String keyWord);
  void delete(ImportDetailDTO importDetailDTO);
  ImportDetailEntity findImportDetailById(Long id);
}
