package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
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
    public ResponseEntity<?> listAllCategory(){
        List<CustomerDTO> listCustomer = customerService.listCustomer();
        if(listCustomer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findCustomer(@PathVariable("id") Long id) {
        CustomerDTO customer = customerService.findCustomerById(id);
//        if(category.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public CustomerEntity saveCustomer(CustomerDTO customer) {

        return customerService.save(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        try {
            CustomerDTO customer = customerService.findCustomerById(id);
            customerService.delete(customer);
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
