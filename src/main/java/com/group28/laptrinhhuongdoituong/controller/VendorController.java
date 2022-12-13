package com.group28.laptrinhhuongdoituong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import com.group28.laptrinhhuongdoituong.converter.VendorConverter;
import com.group28.laptrinhhuongdoituong.dto.VendorDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.VendorService;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

  @Autowired
  private VendorService vendorService;

  private VendorConverter vendorConverter;

  @GetMapping
  public ResponseEntity<Object> listAllVendor() {
    List<VendorEntity> listVendor = vendorService.listVendor();
    if (listVendor.isEmpty()) {
      return ResponseHandler.generateResponse("list vendor is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get vendors successfully", HttpStatus.OK, listVendor);
  }

  @PostMapping
  public ResponseEntity<?> saveVendor(@Valid @RequestBody VendorDTO vendorDTO) {
    VendorEntity vendorEntity = vendorService.save(vendorDTO);
    return ResponseHandler.generateResponse("add vendor successfully", HttpStatus.OK, vendorEntity);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteVendor(@PathVariable("id") Long id) {
    VendorEntity vendorDTO = vendorService.findVendorById(id);
    vendorService.delete(vendorConverter.toDTO(vendorDTO));
    return ResponseHandler.generateResponse("Delete vendor successfully", HttpStatus.OK, vendorDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateVendor(@PathVariable("id") Long id, @Valid @RequestBody VendorDTO vendorDTO) {
    vendorDTO.setId(id);
    VendorEntity vendorById = vendorService.findVendorById(id);
    if (vendorById == null) {
      return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find vedor with id: " + id);
    }
    VendorEntity vendorEntity = vendorService.save(vendorDTO);
    return ResponseHandler.generateResponse("update vendor successfully", HttpStatus.OK, vendorEntity);
  }
}
