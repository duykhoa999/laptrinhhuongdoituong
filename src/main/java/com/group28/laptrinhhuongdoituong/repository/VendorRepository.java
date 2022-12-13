package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Long> {
  @Query(value = "SELECT * FROM categories c WHERE CONCAT(c.id, ' ', c.name, ' ', c.slug) LIKE %?%", nativeQuery=true)
  public List<VendorEntity> search(String keyword);
}
