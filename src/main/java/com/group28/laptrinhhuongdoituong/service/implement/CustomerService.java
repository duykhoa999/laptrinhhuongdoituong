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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerDTO customerDTO) {
        return customerRepository.save(CustomerConverter.toEntity(customerDTO));
    }

    @Override
    public List<CustomerEntity> listCustomer() {
        List<CustomerEntity> list = customerRepository.findAll();
        // List<CustomerDTO> listDTO = new ArrayList<>();
        // for (CustomerEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         CustomerDTO dto = CustomerConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(CustomerDTO customerDTO) {
        customerRepository.delete(CustomerConverter.toEntity(customerDTO));
    }

    @Override
    public CustomerEntity findCustomerById(Long id) {
        if(customerRepository.findById(id).isEmpty()) {
            return null;
        }
        return customerRepository.findById(id).get();
    }
}
