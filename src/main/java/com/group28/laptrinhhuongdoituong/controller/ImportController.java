package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.ImportConverter;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.service.implement.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/import")
public class ImportController {
    @Autowired
    private ImportService importService;

    @GetMapping
    public ResponseEntity<?> listAllImport(){
        List<ImportDTO> listImport = importService.listImport();
        if(listImport.isEmpty()) {
            return ResponseHandler.generateResponse("list import is empty", HttpStatus.OK, "");
        }
        return ResponseHandler.generateResponse("Get list import successfully", HttpStatus.OK, listImport);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findImport(@PathVariable("id") Long id) {
        ImportEntity importDTO = importService.findImportById(id);
        if(importDTO == null) {
            return ResponseHandler.generateResponse("Get import successfully", HttpStatus.OK, "");
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
        importService.delete(ImportConverter.toDTO(importDTO));
        return ResponseHandler.generateResponse("Delete import successfully", HttpStatus.OK, importDTO);
    }
}
