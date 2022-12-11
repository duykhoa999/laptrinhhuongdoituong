package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

  @Query(value = "SELECT * FROM customers c WHERE CONCAT(c.id, ' ', c.name, ' ', c.phone, ' ', c.email) LIKE %?%", nativeQuery=true)
  public List<CustomerEntity> search(String keyword);
}
