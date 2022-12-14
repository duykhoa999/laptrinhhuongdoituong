package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.OrderConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.message.OrderDateRequest;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.OrderService;

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

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConverter orderConverter;

    @GetMapping
    public ResponseEntity<?> listAllOrder(@RequestBody Keyword keyword){
        List<OrderEntity> listOrder = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword.getKeyword())) {
            listOrder = orderService.listOrder(keyword.getKeyword());
        } else {
            listOrder = orderService.listOrder();
        }
        if(listOrder.isEmpty()) {
            return ResponseHandler.generateResponse("list order is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get list order successfully", HttpStatus.OK, listOrder);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOrder(@PathVariable("id") Long id) {
        OrderEntity orderEntity = orderService.findOrderById(id);
        if (orderEntity == null) {
            return ResponseHandler.generateResponse("Order not found", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Get order successfully", HttpStatus.OK, orderEntity);
    }

    @GetMapping(value = "/bystatus/{id}")
    public ResponseEntity<?> findOrderByStatus(@PathVariable("id") Integer id) {
        List<OrderEntity> listOrder = orderService.listOrderByStatus(id);
        if (listOrder.isEmpty()) {
            return ResponseHandler.generateResponse("list order is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get order successfully", HttpStatus.OK, listOrder);
    }

    @PostMapping
    public ResponseEntity<?> saveImport(@Valid @RequestBody OrderDTO orderDTO) {
        OrderEntity entity = orderService.save(orderDTO);
        return ResponseHandler.generateResponse("add order successfully", HttpStatus.OK, entity);
    }

    @PostMapping(value = "/filterdate")
    public ResponseEntity<?> getOrderBetweenDate(@Valid @RequestBody OrderDateRequest orderDateRequest) {
        List<OrderEntity> listOrder = orderService.listOrderBetweenDate(orderDateRequest.getFromDate(), orderDateRequest.getToDate());
        if (listOrder.isEmpty()) {
            return ResponseHandler.generateResponse("list order is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get order successfully", HttpStatus.OK, listOrder);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        OrderEntity entity = orderService.findOrderById(id);
        if(entity == null) {
            return ResponseHandler.generateResponse("Order not found", HttpStatus.OK, null);
        }
        orderService.delete(orderConverter.toDTO(entity));
        return ResponseHandler.generateResponse("Delete category successfully", HttpStatus.OK, entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Long id, @Valid @RequestBody OrderDTO orderDTO) {
        OrderEntity entity = orderService.findOrderById(id);
        if(entity == null) {
            return ResponseHandler.generateResponse("Order not found", HttpStatus.OK, null);
        }
        orderDTO.setId(id);
        OrderEntity orderEntity = orderService.save(orderConverter.toDTO(entity));
        return ResponseHandler.generateResponse("Update Order successfully", HttpStatus.OK, orderEntity);
    }
}
