package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.CustomerEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> listAllCustomer(){
        List<CustomerDTO> listCustomer = customerService.listCustomer();
        if(listCustomer.isEmpty()) {
            return ResponseHandler.generateResponse("list customer is empty", HttpStatus.OK, "");
        }
        return ResponseHandler.generateResponse("Get list customer successfully", HttpStatus.OK, listCustomer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable("id") Long id) {
        CustomerDTO customer = customerService.findCustomerById(id);
        if(customer == null) {
            return ResponseHandler.generateResponse("Get customer successfully", HttpStatus.OK, "");
        }
        return ResponseHandler.generateResponse("Get customer successfully", HttpStatus.OK, customer);
    }
    @PostMapping
    public ResponseEntity<Object> saveCustomer(@Valid @RequestBody CustomerDTO customer) {
        CustomerEntity entity = customerService.save(customer);
        return ResponseHandler.generateResponse("add customer successfully", HttpStatus.OK, entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        CustomerDTO customer = customerService.findCustomerById(id);
        customerService.delete(customer);
        return ResponseHandler.generateResponse("Delete category successfully", HttpStatus.OK, customer);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerDTO customer) {
        CustomerDTO customerById = customerService.findCustomerById(id);
        if (customerById == null) {
            return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find customer by id: " + id);
        }
        customer.setId(id);
        CustomerEntity entity = customerService.save(customer);
        return ResponseHandler.generateResponse("Update customer successfully", HttpStatus.OK, entity);
    }
}
