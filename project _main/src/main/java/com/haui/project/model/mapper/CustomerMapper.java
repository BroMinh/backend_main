package com.haui.project.model.mapper;

import com.haui.project.entity.Customer;

public class CustomerMapper {
    public static Customer toCustomer(Customer customer){
        Customer tmp = new Customer();
        tmp.setCustomerId(customer.getCustomerId());
        tmp.setCustomer_name(customer.getCustomer_name());
        tmp.setCustomerDateOfBirth(customer.getCustomerDateOfBirth());
        tmp.setCustomerIdentityCard(customer.getCustomerIdentityCard());
        tmp.setCustomerCheckIn(customer.getCustomerCheckIn());
        tmp.setCustomercheckout(customer.getCustomercheckout());
//        tmp.setCustomer_number_of_day(customer.getCustomer_number_of_day());
        tmp.setCustomerNumberOfDay(customer.daysBetween());

        return tmp;
    }
}
