package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;

import java.util.List;

public interface IImportService {
    ImportEntity save(ImportDTO importDTO);

    List<ImportDTO> listImport();

    void delete(ImportDTO importDTO);

    ImportEntity findImportById(Long id);
}
