package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.VendorOrderEntity;

@Repository
public interface VendorOrderRepository extends JpaRepository<VendorOrderEntity, Long> {
  @Query(value = "SELECT * FROM vendor_order vo, vendors v, users u WHERE vo.vendor_id = v.id and vo.user_id = u.id and CONCAT(vo.code, ' ', v.code, ' ', u.first_name,' ',u.last_name) LIKE %?%", nativeQuery=true)
  public List<VendorOrderEntity> search(String keyword);
}
