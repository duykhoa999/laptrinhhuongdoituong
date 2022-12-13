package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  @Query(value = "SELECT * FROM categories c WHERE CONCAT(c.id, ' ', c.name, ' ', c.slug) LIKE %?%", nativeQuery=true)
  public List<ProductEntity> search(String keyword);
}
