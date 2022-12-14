package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.OrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailKey;

public interface IOrderDetailService {
  OrderDetailEntity save(OrderDetailDTO orderDetailDTO);
  List<OrderDetailEntity> listImportDetail();
  List<OrderDetailEntity> listImportDetail(Long orderId);
  List<OrderDetailEntity> listImportDetail(String keyWord);
  void delete(OrderDetailDTO orderDetailDTO);
  OrderDetailEntity findOrderDetailById(OrderDetailKey id);
}
