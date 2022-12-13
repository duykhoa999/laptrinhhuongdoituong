package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.OrderDetailConverter;
import com.group28.laptrinhhuongdoituong.dto.OrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailKey;
import com.group28.laptrinhhuongdoituong.repository.OrderDetailRepository;
import com.group28.laptrinhhuongdoituong.service.IOrderDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailService implements IOrderDetailService {

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Autowired
  private OrderDetailConverter orderDetailConverter;

  @Override
  public OrderDetailEntity save(OrderDetailDTO orderDetailDTO) {
    return orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO));
  }

  @Override
  public List<OrderDetailEntity> listImportDetail() {
    List<OrderDetailEntity> list = orderDetailRepository.findAll();
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public List<OrderDetailEntity> listImportDetail(String keyWord) {
    List<OrderDetailEntity> list = orderDetailRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(OrderDetailDTO orderDetailDTO) {
    orderDetailRepository.delete(orderDetailConverter.toEntity(orderDetailDTO));
  }

  @Override
  public OrderDetailEntity findOrderDetailById(OrderDetailKey id) {
    if (orderDetailRepository.findById(id).isEmpty()) {
      return null;
    }
    return orderDetailRepository.findById(id).get();
  }
  
}
