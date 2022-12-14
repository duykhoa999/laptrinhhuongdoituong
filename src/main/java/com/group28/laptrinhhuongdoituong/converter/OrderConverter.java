package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.service.implement.BillService;
import com.group28.laptrinhhuongdoituong.service.implement.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;
    
    public OrderDTO toDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setDate(orderEntity.getDate());
        orderDTO.setReceiver_name(orderEntity.getReceiver_name());
        orderDTO.setReceiver_address(orderEntity.getReceiver_address());
        orderDTO.setReceiver_phone(orderEntity.getReceiver_phone());
        orderDTO.setDelivery_date(orderEntity.getDelivery_date());
        orderDTO.setNote(orderEntity.getNote());
        orderDTO.setStatus(orderEntity.getStatus());
        orderDTO.setPayments(orderEntity.getPayments());
        orderDTO.setCreated_by(orderEntity.getCreated_by());
        orderDTO.setUser_id(orderEntity.getUser().getId());
        orderDTO.setBill_id(orderEntity.getBill().getId());
        orderDTO.setDeleted(orderEntity.getDeleted());

        return orderDTO;
    }

    public OrderEntity toEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setDate(orderDTO.getDate());
        orderEntity.setReceiver_name(orderDTO.getReceiver_name());
        orderEntity.setReceiver_address(orderDTO.getReceiver_address());
        orderEntity.setReceiver_phone(orderDTO.getReceiver_phone());
        orderEntity.setDelivery_date(orderDTO.getDelivery_date());
        orderEntity.setNote(orderDTO.getNote());
        orderEntity.setStatus(orderDTO.getStatus());
        orderEntity.setPayments(orderDTO.getPayments());
        orderEntity.setCreated_by(orderDTO.getCreated_by());
        orderEntity.setUser(userService.findUserById(orderDTO.getUser_id()));
        orderEntity.setBill(orderDTO.getBill_id() != null ? billService.findBillById(orderDTO.getBill_id()) : null);
        orderEntity.setDeleted(orderDTO.getDeleted());

        return orderEntity;
    }
}
