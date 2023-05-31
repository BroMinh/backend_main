package com.haui.project.controller;

import com.haui.project.entity.Customer;
import com.haui.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/search")
    public ResponseEntity<?> searchCustomer(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<Customer> customers = customerService.searchCustomer(name);
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getListCustomer(){
        List<Customer> customers = customerService.getListCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        Customer result = customerService.getCustomerById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCustomer(@RequestBody Customer newCustomer){
        Customer customer = customerService.createCustomer(newCustomer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,@RequestBody Customer upCustomer){
        Customer customer = customerService.updateCustomer(id, upCustomer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping(path="/delete/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        boolean customer = customerService.deleteCustomer(id);
        return ResponseEntity.ok(customer);
    }
}
