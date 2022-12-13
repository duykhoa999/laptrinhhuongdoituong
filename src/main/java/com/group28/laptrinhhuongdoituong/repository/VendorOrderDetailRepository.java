package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailKey;

@Repository
public interface VendorOrderDetailRepository extends JpaRepository<VendorOrderDetailEntity, VendorOrderDetailKey> {
  @Query(value = "SELECT * FROM vendor_order_detail vo WHERE CONCAT(vo.amount, ' ', vo.price) LIKE %?%", nativeQuery=true)
  public List<VendorOrderDetailEntity> search(String keyword);
}
