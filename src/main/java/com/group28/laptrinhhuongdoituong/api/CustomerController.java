package com.group28.laptrinhhuongdoituong.api;

import com.group28.laptrinhhuongdoituong.model.Category;
import com.group28.laptrinhhuongdoituong.model.Customer;
import com.group28.laptrinhhuongdoituong.service.CustomerService;
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
    public ResponseEntity<List<Customer>> listAllCustomer(){
        List<Customer> listCustomer= (List<Customer>) customerService.findAll();
        if(listCustomer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(listCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> findCategory(@PathVariable("id") long id) {
        Optional<Customer> customer = customerService.findOneById(id);
        if(customer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public Customer saveCustomer(Customer customer) {

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
