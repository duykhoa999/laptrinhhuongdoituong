package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group28.laptrinhhuongdoituong.entity.ImportDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.ImportDetailKey;

public interface ImportDetailRepository extends JpaRepository<ImportDetailEntity, ImportDetailKey> {
  @Query(value = "SELECT * FROM import_detail id WHERE CONCAT(id.amount, ' ', id.price) LIKE %?%", nativeQuery=true)
  public List<ImportDetailEntity> search(String keyword);
}
