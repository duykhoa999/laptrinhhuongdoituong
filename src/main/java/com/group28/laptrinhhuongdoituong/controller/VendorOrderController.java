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

import com.group28.laptrinhhuongdoituong.converter.VendorOrderConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.VendorOrderDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.VendorOrderService;

@RestController
@RequestMapping("/api/vendor_order")
public class VendorOrderController {
  
  @Autowired
  private VendorOrderService vendorOrderService;

  @Autowired
  private VendorOrderConverter vendorOrderConverter;

  @GetMapping
  public ResponseEntity<Object> listAllVendorOrder(@RequestBody Keyword keyword) {
    List<VendorOrderEntity> listVendorOrder = new ArrayList<>();
    if (StringUtils.isNotBlank(keyword.getKeyword())) {
      listVendorOrder = vendorOrderService.listVendorOrder(keyword.getKeyword());
    } else {
      listVendorOrder = vendorOrderService.listVendorOrder();
    }
    if (listVendorOrder.isEmpty()) {
      return ResponseHandler.generateResponse("list vendor_order is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get vendor_order successfully", HttpStatus.OK, listVendorOrder);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> findVendorOrder(@PathVariable("id") Long id) {
    VendorOrderEntity entity = vendorOrderService.findVendorOrderById(id);
    if (entity == null) {
      return ResponseHandler.generateResponse("Vendor_order not found", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get Vendor_order successfully", HttpStatus.OK, entity);
  }

  @PostMapping
  public ResponseEntity<?> saveVendorOrder(@Valid @RequestBody VendorOrderDTO vendorOrderDTO) {
    VendorOrderEntity vendorOrderEntity = vendorOrderService.save(vendorOrderDTO);
    return ResponseHandler.generateResponse("add Vendor_order successfully", HttpStatus.OK, vendorOrderEntity);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteVendorOrder(@PathVariable("id") Long id) {
    VendorOrderEntity vendorOrderEntity = vendorOrderService.findVendorOrderById(id);
    if (vendorOrderEntity == null) {
      return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find Vendor_order with id: " + id);
    }
    vendorOrderService.delete(vendorOrderConverter.toDTO(vendorOrderEntity));
    return ResponseHandler.generateResponse("Delete Vendor_order successfully", HttpStatus.OK, vendorOrderEntity);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateVendor(@PathVariable("id") Long id, @Valid @RequestBody VendorOrderDTO vendorOrderDTO) {
    vendorOrderDTO.setId(id);
    VendorOrderEntity vendorOrderById = vendorOrderService.findVendorOrderById(id);
    if (vendorOrderById == null) {
      return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find Vendor_order with id: " + id);
    }
    VendorOrderEntity vendorOrderEntity = vendorOrderService.save(vendorOrderDTO);
    return ResponseHandler.generateResponse("update Vendor_order successfully", HttpStatus.OK, vendorOrderEntity);
  }
}
