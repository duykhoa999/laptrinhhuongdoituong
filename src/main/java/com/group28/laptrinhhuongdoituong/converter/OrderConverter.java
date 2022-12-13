package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.service.implement.CustomerService;
import com.group28.laptrinhhuongdoituong.service.implement.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private static StaffService staffService;

    @Autowired
    private static CustomerService customerService;
    
    public static OrderDTO toDTO(OrderEntity orderEntity) {
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
        orderDTO.setStaff_id(orderEntity.getStaff().getId());
        orderDTO.setCustomer_id(orderEntity.getCustomer().getId());
        orderDTO.setDeleted(orderEntity.getDeleted());

        return orderDTO;
    }

    public static OrderEntity toEntity(OrderDTO orderDTO) {
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
        orderEntity.setStaff(staffService.findStaffById(orderDTO.getStaff_id()));
        orderEntity.setCustomer(customerService.findCustomerById(orderDTO.getCustomer_id()));
        orderEntity.setDeleted(orderDTO.getDeleted());

        return orderEntity;
    }
}
