package com.app.RestDemo.dao;

import com.app.RestDemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

     List<Customer> getCustomers();

     void saveCustomer(Customer theCustomer);

     Customer getCustomer(String theId);

     void deleteCustomer(int theId);
}
