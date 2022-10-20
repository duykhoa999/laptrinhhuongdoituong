package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity save(OrderDTO order);

    List<OrderDTO> listOrder();

    void delete(OrderDTO orderDTO);

    OrderDTO findOrderById(Long id);
}
