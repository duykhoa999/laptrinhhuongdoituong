package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
