package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.ImportEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImportRepository extends JpaRepository<ImportEntity, Long> {
  @Query(value = "SELECT * FROM imports c, users u, vendor_order vo WHERE c.user_id = u.id and c.vendor_order_id = vo.id and CONCAT(c.code,' ',u.first_name,' ',u.last_name,' ',vo.code) LIKE %?%", nativeQuery=true)
  public List<ImportEntity> search(String keyword);
}
