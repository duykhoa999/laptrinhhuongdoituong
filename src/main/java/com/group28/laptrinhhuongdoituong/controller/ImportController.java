package com.group28.laptrinhhuongdoituong.controller;

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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ImportController {
    @Autowired
    private ImportService importService;

    @RequestMapping(value = "/import/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllImport(){
        List<ImportDTO> listImport = importService.listImport();
        if(listImport.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImport, HttpStatus.OK);
    }

    @RequestMapping(value = "/import/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findImport(@PathVariable("id") Long id) {
        ImportDTO importDTO = importService.findImportById(id);
//        if(category.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(importDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/import/", method = RequestMethod.POST)
    public ImportEntity saveImport(ImportDTO importDTO) {

        return importService.save(importDTO);
    }

    @RequestMapping(value = "/import/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteImport(@PathVariable("id") Long id) {
        try {
            ImportDTO importDTO = importService.findImportById(id);
            importService.delete(importDTO);
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
