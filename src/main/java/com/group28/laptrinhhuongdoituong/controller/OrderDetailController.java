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

import com.group28.laptrinhhuongdoituong.converter.OrderDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.OrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailKey;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.OrderDetailService;

@RestController
@RequestMapping("/api/Order_detail")
public class OrderDetailController {
  
  @Autowired
  private OrderDetailService orderDetailService;

  @Autowired
  private OrderDetailConverter orderDetailConverter;

  @GetMapping
  public ResponseEntity<?> listAllOrderDetail(@RequestBody Keyword keyword) {
    List<OrderDetailEntity> orderDetailEntity = new ArrayList<>();
    if (StringUtils.isNotBlank(keyword.getKeyword())) {
      orderDetailEntity = orderDetailService.listImportDetail(keyword.getKeyword());
    } else {
      orderDetailEntity = orderDetailService.listImportDetail();
    }
    if (orderDetailEntity.isEmpty()) {
      return ResponseHandler.generateResponse("list order_detail is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get list order_detail successfully", HttpStatus.OK, orderDetailEntity);
  }

  @GetMapping(value = "/{order_id}/{product_id}")
  public ResponseEntity<?> findOrderDetail(@PathVariable("order_id") Long order_id, @PathVariable("product_id") Long product_id) {
    OrderDetailKey orderDetailKey = new OrderDetailKey();
    orderDetailKey.setOrderId(order_id);
    orderDetailKey.setProductId(product_id);
    OrderDetailEntity orderDetailEntity = orderDetailService.findOrderDetailById(orderDetailKey);
    if (orderDetailEntity == null) {
      return ResponseHandler.generateResponse("Get order_detail successfully", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get order_detail successfully", HttpStatus.OK, orderDetailEntity);
  }

  @PostMapping
  public ResponseEntity<Object> saveOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailDTO) {
    OrderDetailEntity entity = orderDetailService.save(orderDetailDTO);
    return ResponseHandler.generateResponse("add order_detail successfully", HttpStatus.OK, entity);
  }

  @DeleteMapping(value = "/{order_id}/{product_id}")
  public ResponseEntity<?> deleteOrderDetail(@PathVariable("order_id") Long order_id, @PathVariable("product_id") Long product_id) {
    OrderDetailKey orderDetailKey = new OrderDetailKey();
    orderDetailKey.setOrderId(order_id);
    orderDetailKey.setProductId(product_id);
    OrderDetailEntity orderDetailEntity = orderDetailService.findOrderDetailById(orderDetailKey);
    if (orderDetailEntity == null) {
      return ResponseHandler.generateResponse("order_detail not found", HttpStatus.OK, null);
    }
    orderDetailService.delete(orderDetailConverter.toDTO(orderDetailEntity));
    return ResponseHandler.generateResponse("Delete order_detail successfully", HttpStatus.OK, orderDetailEntity);
  }

  @PutMapping(value = "/{order_id}/{product_id}")
  public ResponseEntity<?> updateOrderDetail(@PathVariable("order_id") Long order_id, @PathVariable("product_id") Long product_id, @Valid @RequestBody OrderDetailDTO orderDetailDTO) {
    OrderDetailKey orderDetailKey = new OrderDetailKey();
    orderDetailKey.setOrderId(order_id);
    orderDetailKey.setProductId(product_id);
    OrderDetailEntity entity = orderDetailService.findOrderDetailById(orderDetailKey);
    if (entity == null) {
      return ResponseHandler.generateResponse("order_detail not found", HttpStatus.OK, null);
    }
    orderDetailDTO.setOrder_id(orderDetailKey.getOrderId());
    orderDetailDTO.setProduct_id(orderDetailKey.getProductId());
    OrderDetailEntity orderDetailEntity = orderDetailService.save(orderDetailDTO);
    return ResponseHandler.generateResponse("Update order_detail successfully", HttpStatus.OK, orderDetailEntity);
  }
}
