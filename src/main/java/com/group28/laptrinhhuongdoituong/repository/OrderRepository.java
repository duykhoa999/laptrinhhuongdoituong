package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.OrderEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  @Query(value = "SELECT * FROM orders o, users u WHERE o.user_id = u.id and CONCAT(u.receiver_name, ' ', u.receiver_address, ' ', o.receiver_phone, ' ', o.delivery_date, ' ', o.note, ' ', o.status, ' ', o.payments,' ',u.first_name,' ',u.last_name) LIKE %?%", nativeQuery=true)
  public List<OrderEntity> search(String keyword);

  @Query(value = "SELECT * FROM orders o WHERE o.date BETWEEN :startDate AND :endDate + INTERVAL 1 DAY", nativeQuery=true)
  public List<OrderEntity> getOrderBetweenDate(@Param("startDate")Date fromDate, @Param("endDate")Date toDate);

}
