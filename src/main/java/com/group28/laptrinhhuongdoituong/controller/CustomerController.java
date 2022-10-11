package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import com.group28.laptrinhhuongdoituong.service.implement.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerEntity>> listAllCustomer(){
        List<CustomerEntity> listCustomer= (List<CustomerEntity>) customerService.findAll();
        if(listCustomer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CustomerEntity>>(listCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<CustomerEntity>> findCustomer(@PathVariable("id") long id) {
        Optional<CustomerEntity> customer = customerService.findOneById(id);
        if(customer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<CustomerEntity>>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public CustomerEntity saveCustomer(CustomerEntity customer) {

        return customerService.create(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
        try {
            customerService.remove(id);
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
