package com.app.RestDemo.service;

import com.app.RestDemo.entity.Customer;

import java.util.List;

public interface CustomerService  {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer );

    public Customer getCustomer(String theId);

    public void deleteCustomer(int theId);
}
