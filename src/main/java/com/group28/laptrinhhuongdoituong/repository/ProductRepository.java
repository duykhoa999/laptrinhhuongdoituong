package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  @Query(value = "SELECT * FROM products p, categories c, vendors v WHERE p.category_id = c.id and p.vendor_id = v.id and CONCAT(p.code,' ',p.name,' ',p.slug,' ',p.price,' ',p.description,' ',p.image,' ',p.amount,' ',c.name) LIKE %?%", nativeQuery=true)
  public List<ProductEntity> search(String keyword);
}
