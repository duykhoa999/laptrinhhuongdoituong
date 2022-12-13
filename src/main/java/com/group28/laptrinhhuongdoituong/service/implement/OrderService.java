package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.OrderConverter;
import com.group28.laptrinhhuongdoituong.dto.OrderDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderEntity;
import com.group28.laptrinhhuongdoituong.repository.OrderRepository;
import com.group28.laptrinhhuongdoituong.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderEntity save(OrderDTO orderDTO) {
        return orderRepository.save(orderConverter.toEntity(orderDTO));
    }

    @Override
    public List<OrderEntity> listOrder() {
        List<OrderEntity> list = orderRepository.findAll();
        // List<OrderDTO> listDTO = new ArrayList<>();
        // for (OrderEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         OrderDTO dto = orderConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(OrderDTO orderDTO) {
        orderRepository.delete(orderConverter.toEntity(orderDTO));
    }

    @Override
    public OrderEntity findOrderById(Long id) {
        if(orderRepository.findById(id).isEmpty()) {
            return null;
        }
        return orderRepository.findById(id).get();
    }

    @Override
    public List<OrderEntity> listOrder(String keyWord) {
        List<OrderEntity> list = orderRepository.search(keyWord);
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }
}
