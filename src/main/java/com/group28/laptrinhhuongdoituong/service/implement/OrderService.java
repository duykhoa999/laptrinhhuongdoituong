package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.ImportConverter;
import com.group28.laptrinhhuongdoituong.converter.OrderConverter;
import com.group28.laptrinhhuongdoituong.dto.ImportDTO;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.ImportEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.repository.ImportRepository;
import com.group28.laptrinhhuongdoituong.repository.OrderRepository;
import com.group28.laptrinhhuongdoituong.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private final OrderRepository orderRepository;

    private final OrderConverter orderConverter;

    @Override
    public OrderEntity save(OrderDTO orderDTO) {
        return orderRepository.save(orderConverter.toEntity(orderDTO));
    }

    @Override
    public List<OrderDTO> listOrder() {
        List<OrderEntity> list = orderRepository.findAll();
        List<OrderDTO> listDTO = new ArrayList<>();
        for (OrderEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                OrderDTO dto = orderConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(OrderDTO orderDTO) {
        orderRepository.delete(orderConverter.toEntity(orderDTO));
    }

    @Override
    public OrderDTO findOrderById(Long id) {
        OrderDTO orderDTO = new OrderDTO();
        if(orderRepository.findById(id).isEmpty()) {
            return orderDTO;
        }
        orderDTO = orderConverter.toDTO(orderRepository.findById(id).get());
        return orderDTO;
    }
}
