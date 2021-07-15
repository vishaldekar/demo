package com.app.RestDemo.service;

import com.app.RestDemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerServiceWithRepo {

    public List<Customer> getCustomers();

    public Customer saveCustomer(Customer theCustomer );

    public Customer getCustomer(String theId);

    public void deleteCustomer(String theId);

    public Customer updateCustomer(String theId , Customer customer);
}
