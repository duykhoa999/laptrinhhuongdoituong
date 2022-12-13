package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.CategoryConverter;
import com.group28.laptrinhhuongdoituong.converter.ImportConverter;
import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import com.group28.laptrinhhuongdoituong.repository.ImportRepository;
import com.group28.laptrinhhuongdoituong.service.IImportService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ImportService implements IImportService {
    @Autowired
    private final ImportRepository importRepository;


    @Override
    public ImportEntity save(ImportDTO importDTO) {
        return importRepository.save(ImportConverter.toEntity(importDTO));
    }

    @Override
    public List<ImportDTO> listImport() {
        List<ImportEntity> list = importRepository.findAll();
        List<ImportDTO> listDTO = new ArrayList<>();
        for (ImportEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                ImportDTO dto = ImportConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(ImportDTO importDTO) {
        importRepository.delete(ImportConverter.toEntity(importDTO));
    }

    @Override
    public ImportEntity findImportById(Long id) {
        if(importRepository.findById(id).isEmpty()) {
            return null;
        }
        return importRepository.findById(id).get();
    }
}
