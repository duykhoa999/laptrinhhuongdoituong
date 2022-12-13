package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.ImportConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.service.implement.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/import")
public class ImportController {
    @Autowired
    private ImportService importService;

    private ImportConverter importConverter;

    @GetMapping
    public ResponseEntity<?> listAllImport(){
        List<ImportDTO> listImport = importService.listImport();
        if(listImport.isEmpty()) {
            return ResponseHandler.generateResponse("list import is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get list import successfully", HttpStatus.OK, listImport);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findImport(@PathVariable("id") Long id) {
        ImportEntity importDTO = importService.findImportById(id);
        if(importDTO == null) {
            return ResponseHandler.generateResponse("Get import successfully", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Get import successfully", HttpStatus.OK, importDTO);
    }

    @PostMapping
    public ResponseEntity<Object> saveImport(@Valid @RequestBody ImportDTO importDTO) {
        ImportEntity entity = importService.save(importDTO);
        return ResponseHandler.generateResponse("add import successfully", HttpStatus.OK, entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteImport(@PathVariable("id") Long id) {
        ImportEntity importDTO = importService.findImportById(id);
        importService.delete(importConverter.toDTO(importDTO));
        return ResponseHandler.generateResponse("Delete import successfully", HttpStatus.OK, importDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateImport(@PathVariable("id") Long id, @Valid @RequestBody ImportDTO importDTO) {
        ImportEntity entity = importService.findImportById(id);
        if(entity == null) {
            return ResponseHandler.generateResponse("Import not found", HttpStatus.OK, null);
        }
        importDTO.setId(id);
        ImportEntity importEntity = importService.save(importConverter.toDTO(entity));
        return ResponseHandler.generateResponse("Update import successfully", HttpStatus.OK, importEntity);
    }
}
