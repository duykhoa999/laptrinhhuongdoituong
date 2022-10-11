package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import com.group28.laptrinhhuongdoituong.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity create(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public void remove(Long id){
        customerRepository.deleteById(id);
    }

    public Iterable<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

    public Optional<CustomerEntity> findOneById(long id){
        return customerRepository.findById(id);
    }
}
