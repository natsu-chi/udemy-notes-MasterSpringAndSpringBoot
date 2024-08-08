package com.chi.demo10.accounts.mapper;

import com.chi.demo10.accounts.dto.CustomerDto;
import com.chi.demo10.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobile(customer.getMobile());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customerDto.setCustomerId(customer.getCustomerId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobile(customerDto.getMobile());
        return customer;
    }

}