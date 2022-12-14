package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailKey;

public interface IImportDetailService {
  ImportDetailEntity save(ImportDetailDTO importDetailDTO);
  List<ImportDetailEntity> listImportDetail();
  List<ImportDetailEntity> listImportDetail(Long importId);
  List<ImportDetailEntity> listImportDetail(String keyWord);
  void delete(ImportDetailDTO importDetailDTO);
  ImportDetailEntity findImportDetailById(ImportDetailKey id);
}
