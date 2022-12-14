package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

  @Query(value = "SELECT * FROM categories c WHERE CONCAT(c.id, ' ', c.name, ' ', c.slug) LIKE %?%", nativeQuery=true)
  public List<CategoryEntity> search(String keyword);
}
