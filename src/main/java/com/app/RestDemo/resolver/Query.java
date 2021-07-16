package com.app.RestDemo.resolver;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.repository.CustomerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    CustomerRepository customerRepository ;

    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(String id ){
        return customerRepository.findById(id).get();
    }

}
