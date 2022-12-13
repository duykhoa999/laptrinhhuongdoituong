package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.OrderConverter;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.service.implement.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private OrderConverter orderConverter;

    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllOrder(){
        List<OrderEntity> listOrder = orderService.listOrder();
        if(listOrder.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOrder(@PathVariable("id") Long id) {
        OrderEntity orderDTO = orderService.findOrderById(id);
//        if(category.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public OrderEntity saveImport(OrderDTO orderDTO) {

        return orderService.save(orderDTO);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        try {
            OrderEntity orderDTO = orderService.findOrderById(id);
            orderService.delete(orderConverter.toDTO(orderDTO));
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
