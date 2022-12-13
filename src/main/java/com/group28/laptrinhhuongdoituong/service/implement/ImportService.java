package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.ImportConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.repository.ImportRepository;
import com.group28.laptrinhhuongdoituong.service.IImportService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ImportService implements IImportService {
    @Autowired
    private final ImportRepository importRepository;
    @Autowired
    private ImportConverter importConverter;

    @Override
    public ImportEntity save(ImportDTO importDTO) {
        return importRepository.save(importConverter.toEntity(importDTO));
    }

    @Override
    public List<ImportEntity> listImport() {
        List<ImportEntity> list = importRepository.findAll();
        // List<ImportDTO> listDTO = new ArrayList<>();
        // for (ImportEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         ImportDTO dto = importConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(ImportDTO importDTO) {
        importRepository.delete(importConverter.toEntity(importDTO));
    }

    @Override
    public ImportEntity findImportById(Long id) {
        if(importRepository.findById(id).isEmpty()) {
            return null;
        }
        return importRepository.findById(id).get();
    }

    @Override
    public List<ImportEntity> listImport(String keyWord) {
        // TODO Auto-generated method stub
        return null;
    }
}
