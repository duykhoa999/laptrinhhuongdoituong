package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    OrderEntity save(OrderDTO order);
    List<OrderEntity> listOrder();
    List<OrderEntity> listOrder(String keyWord);
    void delete(OrderDTO orderDTO);
    OrderEntity findOrderById(Long id);
    List<OrderEntity> listOrderByStatus(Integer Id);
    List<OrderEntity> listOrderByUser(Long Id);
    List<OrderEntity> listOrderBetweenDate(Date fromDate, Date toDate);
    Integer updateStatus(Long id, Long status);
}
