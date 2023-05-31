package com.haui.project.service;

import com.haui.project.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.haui.project.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerService {
//    @Autowired
//    private CustomerRepository customerRepository;
//}
@Service
public interface CustomerService {
    public List<Customer> getListCustomer();
    public Customer getCustomerById(Long id);
    public List<Customer> searchCustomer(String keyword);
    public Customer createCustomer(Customer newCustomer);
    public boolean deleteCustomer(Long id);
    public Customer updateCustomer(Long id, Customer upCustomer);

}
