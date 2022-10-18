package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public CustomerDTO toDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setGender(customerEntity.getGender());
        customerDTO.setDob(customerEntity.getDob());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setPhone(customerEntity.getPhone());
        customerDTO.setEmail(customerEntity.getEmail());
        customerDTO.setPassword(customerEntity.getPassword());
        customerDTO.setRole_id(customerEntity.getRole_id());
        customerDTO.setDeleted(customerEntity.getDeleted());

        return customerDTO;
    }

    public CustomerEntity toEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDTO.getId());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setDob(customerDTO.getDob());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setRole_id(customerDTO.getRole_id());
        customerEntity.setDeleted(customerDTO.getDeleted());

        return customerEntity;
    }
}
