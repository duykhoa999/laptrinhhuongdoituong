package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    CustomerEntity save(CustomerDTO customer);

    List<CustomerDTO> listCustomer();

    void delete(CustomerDTO customerDTO);

    CustomerDTO findCustomerById(Long id);
}
