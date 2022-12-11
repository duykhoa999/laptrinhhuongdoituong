package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.CategoryConverter;
import com.group28.laptrinhhuongdoituong.converter.CustomerConverter;
import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import com.group28.laptrinhhuongdoituong.repository.CustomerRepository;
import com.group28.laptrinhhuongdoituong.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    @Override
    public CustomerEntity save(CustomerDTO customerDTO) {
        return customerRepository.save(customerConverter.toEntity(customerDTO));
    }

    @Override
    public List<CustomerDTO> listCustomer() {
        List<CustomerEntity> list = customerRepository.findAll();
        List<CustomerDTO> listDTO = new ArrayList<>();
        for (CustomerEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                CustomerDTO dto = customerConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(CustomerDTO customerDTO) {
        customerRepository.delete(customerConverter.toEntity(customerDTO));
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        CustomerDTO customerDTO = new CustomerDTO();
        if(customerRepository.findById(id).isEmpty()) {
            return null;
        }
        customerDTO = customerConverter.toDTO(customerRepository.findById(id).get());
        return customerDTO;
    }
}
