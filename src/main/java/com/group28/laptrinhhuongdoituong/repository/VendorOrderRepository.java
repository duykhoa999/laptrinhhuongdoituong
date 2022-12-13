package com.group28.laptrinhhuongdoituong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;

@Repository
public interface VendorOrderRepository extends JpaRepository<VendorOrderEntity, Long> {
  
}
