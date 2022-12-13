package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.OrderEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  @Query(value = "SELECT * FROM categories c WHERE CONCAT(c.id, ' ', c.name, ' ', c.slug) LIKE %?%", nativeQuery=true)
  public List<OrderEntity> search(String keyword);
}
