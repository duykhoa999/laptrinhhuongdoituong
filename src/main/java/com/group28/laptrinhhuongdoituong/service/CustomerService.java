package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.model.Customer;
import com.group28.laptrinhhuongdoituong.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public void remove(Long id){
        customerRepository.deleteById(id);
    }

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findOneById(long id){
        return customerRepository.findById(id);
    }
}
