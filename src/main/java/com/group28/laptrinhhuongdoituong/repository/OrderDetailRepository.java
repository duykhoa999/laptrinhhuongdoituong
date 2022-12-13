package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.OrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.OrderDetailKey;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailKey> {
  @Query(value = "SELECT * FROM order_detail od WHERE CONCAT(od.amount, ' ', od.price) LIKE %?%", nativeQuery=true)
  public List<OrderDetailEntity> search(String keyword);
}
