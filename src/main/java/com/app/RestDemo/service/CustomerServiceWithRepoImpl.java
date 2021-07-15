package com.app.RestDemo.service;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceWithRepoImpl implements CustomerServiceWithRepo {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer theCustomer) {
        return  customerRepository.save(theCustomer);
    }



    @Override
    public Customer getCustomer(String theId) {
        Customer customer=customerRepository.findById(theId).get();
        if(customer==null)
            throw  new RuntimeException("Customer not found");

        return customer;

    }

    @Override
    public void deleteCustomer(String theId) {
        customerRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException(theId+" not found"));
        customerRepository.deleteById(theId);
    }

    @Override
    public Customer updateCustomer(String theId, Customer customer) {
        customerRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException(theId));

        customer.setId(theId);
        return customerRepository.save(customer);

    }
}
