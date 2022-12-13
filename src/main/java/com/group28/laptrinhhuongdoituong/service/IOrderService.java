package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity save(OrderDTO order);
    List<OrderEntity> listOrder();
    List<OrderEntity> listOrder(String keyWord);
    void delete(OrderDTO orderDTO);
    OrderEntity findOrderById(Long id);
}
