package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.BillEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

  @Query(value = "SELECT * FROM bills c WHERE CONCAT(c.id, ' ', c.name, ' ', c.slug) LIKE %?%", nativeQuery=true)
  public List<BillEntity> search(String keyword);
}
