package com.haui.project.service;

import com.haui.project.entity.Customer;
import com.haui.project.entity.User;
import com.haui.project.exeption.NotFoundException;
import com.haui.project.model.mapper.CustomerMapper;
import com.haui.project.model.mapper.RoomMapper;
import com.haui.project.model.mapper.UserMapper;
import com.haui.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService{
    private static ArrayList<Customer> customers = new ArrayList<>();
    @Autowired
    private CustomerRepository customerRepository;

//    static{
//        customers.add(new Customer(1,"Dylan Riggs", "01/03/1999","0935235621","11/02/2021","13/02/2021",3));
//        customers.add(new Customer(2,"Madilynn Duran","03/02/1999","0935111435","03/03/2021","23/03/2021",11));
//    }


    @Override
    public List<Customer> getListCustomer() {
        List<Customer> result = new ArrayList<>();
        for(Customer customer:customerRepository.findAll()){
            result.add(CustomerMapper.toCustomer(customer));
        }
        return result;
    }

//    total date


    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer không tồn tại trong hệ thống"));
        return CustomerMapper.toCustomer(customer);
    }

    public String unAccent(String s){
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}");
        return pattern.matcher(temp).replaceAll("");
    }
    @Override
    public List<Customer> searchCustomer(String keyword) {
        List<Customer> result = new ArrayList<>();
        for(Customer customer:customers){
            if(customer.getCustomer_name().toLowerCase().contains(keyword.toLowerCase())
                    || unAccent(customer.getCustomer_name()).toLowerCase().contains(unAccent(keyword.toLowerCase()))){
                result.add(CustomerMapper.toCustomer(customer));
            }else {
                throw new NotFoundException("Không có customer cần tìm kiếm!");
            }
        }
        return result;
    }

    @Override
    public Customer createCustomer(Customer newCustomer){

        return customerRepository.save(CustomerMapper.toCustomer(newCustomer));
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)){
            throw new NotFoundException("Customer không tồn tại trong hệ thống");
        }
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public Customer updateCustomer(Long id, Customer upCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setCustomer_name(upCustomer.getCustomer_name());
            customer.setCustomerDateOfBirth(upCustomer.getCustomerDateOfBirth());
            customer.setCustomerIdentityCard(upCustomer.getCustomerIdentityCard());
            customer.setCustomerCheckIn(upCustomer.getCustomerCheckIn());
            customer.setCustomercheckout(upCustomer.getCustomercheckout());
            return  customerRepository.save(customer);
        }).orElseThrow(() -> new NotFoundException("Customer không tồn tại trong hệ thống"));
    }
}
