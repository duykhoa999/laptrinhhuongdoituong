package com.group28.laptrinhhuongdoituong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group28.laptrinhhuongdoituong.converter.ImportDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDetailDTO;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailKey;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.ImportDetailService;

@RestController
@RequestMapping("/api/import_detail")
public class ImportDetailController {

  @Autowired
  private ImportDetailService importDetailService;

  @Autowired
  private ImportDetailConverter importDetailConverter;

  @GetMapping
  public ResponseEntity<?> listAllImportDetail(@RequestBody Keyword keyword) {
    List<ImportDetailEntity> listImportDetail = new ArrayList<>();
    if (StringUtils.isNotBlank(keyword.getKeyword())) {
      listImportDetail = importDetailService.listImportDetail(keyword.getKeyword());
    } else {
      listImportDetail = importDetailService.listImportDetail();
    }
    if (listImportDetail.isEmpty()) {
      return ResponseHandler.generateResponse("list import_detail is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get list import_detail successfully", HttpStatus.OK, listImportDetail);
  }

  @GetMapping(value = "/{import_id}")
  public ResponseEntity<?> findImportDetailByImportId(@PathVariable("import_id") Long import_id) {
    List<ImportDetailEntity> list = importDetailService.listImportDetail(import_id);
    if (list.isEmpty()) {
      return ResponseHandler.generateResponse("Get import_detail successfully", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get import_detail successfully", HttpStatus.OK, list);
  }

  @GetMapping(value = "/{import_id}/{product_id}")
  public ResponseEntity<?> findImportDetail(@PathVariable("import_id") Long import_id, @PathVariable("product_id") Long product_id) {
    ImportDetailKey importDetailKey = new ImportDetailKey();
    importDetailKey.setImportId(import_id);
    importDetailKey.setProductId(product_id);
    ImportDetailEntity importDetailEntity = importDetailService.findImportDetailById(importDetailKey);
    if (importDetailEntity == null) {
      return ResponseHandler.generateResponse("Get import_detail successfully", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get import_detail successfully", HttpStatus.OK, importDetailEntity);
  }

  @PostMapping
  public ResponseEntity<Object> saveImportDetail(@Valid @RequestBody ImportDetailDTO importDetailDTO) {
    ImportDetailEntity entity = importDetailService.save(importDetailDTO);
    return ResponseHandler.generateResponse("add import_detail successfully", HttpStatus.OK, entity);
  }

  @DeleteMapping(value = "/{import_id}/{product_id}")
  public ResponseEntity<?> deleteImportDetail(@PathVariable("import_id") Long import_id, @PathVariable("product_id") Long product_id) {
    ImportDetailKey importDetailKey = new ImportDetailKey();
    importDetailKey.setImportId(import_id);
    importDetailKey.setProductId(product_id);
    ImportDetailEntity importDetailEntity = importDetailService.findImportDetailById(importDetailKey);
    importDetailService.delete(importDetailConverter.toDTO(importDetailEntity));
    return ResponseHandler.generateResponse("Delete import_detail successfully", HttpStatus.OK, importDetailEntity);
  }

  @PutMapping(value = "/{import_id}/{product_id}")
  public ResponseEntity<?> updateImportDetail(@PathVariable("import_id") Long import_id, @PathVariable("product_id") Long product_id, @Valid @RequestBody ImportDetailDTO importDetailDTO) {
    ImportDetailKey importDetailKey = new ImportDetailKey();
    importDetailKey.setImportId(import_id);
    importDetailKey.setProductId(product_id);
    ImportDetailEntity entity = importDetailService.findImportDetailById(importDetailKey);
    if (entity == null) {
      return ResponseHandler.generateResponse("import_detail not found", HttpStatus.OK, null);
    }
    importDetailDTO.setImport_id(importDetailKey.getImportId());
    importDetailDTO.setProduct_id(importDetailKey.getProductId());
    ImportDetailEntity importDetailEntity = importDetailService.save(importDetailDTO);
    return ResponseHandler.generateResponse("Update import_detail successfully", HttpStatus.OK, importDetailEntity);
  }

}
