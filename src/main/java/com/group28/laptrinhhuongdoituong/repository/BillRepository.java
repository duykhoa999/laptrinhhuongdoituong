package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.BillEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

  @Query(value = "SELECT * FROM bills b, orders o, users u WHERE b.order_id = o.id and b.user_id = u.id and CONCAT(b.code,' ',b.total,' ',o.code,' ',u.first_name,' ',u.last_name) LIKE %?%", nativeQuery=true)
  public List<BillEntity> search(String keyword);
}
