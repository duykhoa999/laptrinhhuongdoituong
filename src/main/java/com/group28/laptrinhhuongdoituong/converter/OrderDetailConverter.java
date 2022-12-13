package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.OrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailEntity;
import com.group28.laptrinhhuongdoituong.service.implement.OrderService;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;

@Component
public class OrderDetailConverter {
  
  @Autowired
  private OrderService orderService;

  @Autowired
  private ProductService productService;

  public OrderDetailDTO toDTO(OrderDetailEntity orderDetailEntity) {
    OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
    orderDetailDTO.setOrder_id(orderDetailEntity.getOrder_id().getId());
    orderDetailDTO.setProduct_id(orderDetailEntity.getProduct_id().getId());
    orderDetailDTO.setAmount(orderDetailEntity.getAmount());
    orderDetailDTO.setPrice(orderDetailEntity.getPrice());
    orderDetailDTO.setDeleted(orderDetailEntity.getDeleted());

    return orderDetailDTO;
  }

  public OrderDetailEntity toEntity(OrderDetailDTO orderDetailDTO) {
    OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
    orderDetailEntity.setOrder_id(orderService.findOrderById(orderDetailDTO.getOrder_id()));
    orderDetailEntity.setProduct_id(productService.findProductById(orderDetailDTO.getProduct_id()));
    orderDetailEntity.setAmount(orderDetailDTO.getAmount());
    orderDetailEntity.setPrice(orderDetailDTO.getPrice());
    orderDetailEntity.setDeleted(orderDetailDTO.getDeleted());

    return orderDetailEntity;
  }
}
