package com.group28.laptrinhhuongdoituong.repository;

import com.group28.laptrinhhuongdoituong.model.Category;
import com.group28.laptrinhhuongdoituong.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
