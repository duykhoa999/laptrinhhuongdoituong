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

import com.group28.laptrinhhuongdoituong.converter.VendorOrderDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.VendorOrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailKey;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.VendorOrderDetailService;

@RestController
@RequestMapping("/api/vendor_order_detail")
public class VendorOrderDetailController {
  
  @Autowired
  private VendorOrderDetailService vendorOrderDetailService;

  @Autowired
  private VendorOrderDetailConverter vendorOrderDetailConverter;

  @GetMapping
  public ResponseEntity<?> listAllVendorOrderDetail(@RequestBody Keyword keyword) {
    List<VendorOrderDetailEntity> vendorOrderDetailEntities = new ArrayList<>();
    if (StringUtils.isNotBlank(keyword.getKeyword())) {
      vendorOrderDetailEntities = vendorOrderDetailService.listVendorOrderDetail(keyword.getKeyword());
    } else {
      vendorOrderDetailEntities = vendorOrderDetailService.listVendorOrderDetail();
    }
    if (vendorOrderDetailEntities.isEmpty()) {
      return ResponseHandler.generateResponse("list Vendor_order_detail is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get list Vendor_order_detail successfully", HttpStatus.OK, vendorOrderDetailEntities);
  }

  @GetMapping(value = "/{vendor_order_id}/{product_id}")
  public ResponseEntity<?> findVendorOrderDetail(@PathVariable("vendor_order_id") Long vendor_order_id, @PathVariable("product_id") Long product_id) {
    VendorOrderDetailKey vendorOrderDetailKey = new VendorOrderDetailKey();
    vendorOrderDetailKey.setVendorOrderId(vendor_order_id);
    vendorOrderDetailKey.setProductId(product_id);
    VendorOrderDetailEntity vendorOrderDetailEntity = vendorOrderDetailService.findVendorOrderDetailById(vendorOrderDetailKey);
    if (vendorOrderDetailEntity == null) {
      return ResponseHandler.generateResponse("Get Vendor_order_detail successfully", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get Vendor_order_detail successfully", HttpStatus.OK, vendorOrderDetailEntity);
  }

  @PostMapping
  public ResponseEntity<Object> saveVendorOrderDetail(@Valid @RequestBody VendorOrderDetailDTO vendorOrderDetailDTO) {
    VendorOrderDetailEntity entity = vendorOrderDetailService.save(vendorOrderDetailDTO);
    return ResponseHandler.generateResponse("add Vendor_order_detail successfully", HttpStatus.OK, entity);
  }

  @DeleteMapping(value = "/{vendor_order_id}/{product_id}")
  public ResponseEntity<?> deleteVendorOrderDetail(@PathVariable("vendor_order_id") Long vendor_order_id, @PathVariable("product_id") Long product_id) {
    VendorOrderDetailKey vendorOrderDetailKey = new VendorOrderDetailKey();
    vendorOrderDetailKey.setVendorOrderId(vendor_order_id);
    vendorOrderDetailKey.setProductId(product_id);
    VendorOrderDetailEntity vendorOrderDetailEntity = vendorOrderDetailService.findVendorOrderDetailById(vendorOrderDetailKey);
    if (vendorOrderDetailEntity == null) {
      return ResponseHandler.generateResponse("Vendor_order_detail not found", HttpStatus.OK, null);
    }
    vendorOrderDetailService.delete(vendorOrderDetailConverter.toDTO(vendorOrderDetailEntity));
    return ResponseHandler.generateResponse("Delete Vendor_order_detail successfully", HttpStatus.OK, vendorOrderDetailEntity);
  }

  @PutMapping(value = "/{vendor_order_id}/{product_id}")
  public ResponseEntity<?> updateVendorOrderDetail(@PathVariable("vendor_order_id") Long vendor_order_id, @PathVariable("product_id") Long product_id, @Valid @RequestBody VendorOrderDetailDTO vendorOrderDetailDTO) {
    VendorOrderDetailKey vendorOrderDetailKey = new VendorOrderDetailKey();
    vendorOrderDetailKey.setVendorOrderId(vendor_order_id);
    vendorOrderDetailKey.setProductId(product_id);
    VendorOrderDetailEntity entity = vendorOrderDetailService.findVendorOrderDetailById(vendorOrderDetailKey);
    if (entity == null) {
      return ResponseHandler.generateResponse("Vendor_order_detail not found", HttpStatus.OK, null);
    }
    vendorOrderDetailDTO.setVendor_order_id(vendorOrderDetailKey.getVendorOrderId());
    vendorOrderDetailKey.setProductId(vendorOrderDetailKey.getProductId());
    VendorOrderDetailEntity vendorOrderDetailEntity = vendorOrderDetailService.save(vendorOrderDetailDTO);
    return ResponseHandler.generateResponse("Update Vendor_order_detail successfully", HttpStatus.OK, vendorOrderDetailEntity);
  }
}
