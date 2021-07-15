package com.app.RestDemo.resolver;

import com.app.RestDemo.entity.AddCustomerInput;
import com.app.RestDemo.entity.BankAccount;
import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.entity.UpdateCustomerInput;
import com.app.RestDemo.repository.BankAccountRepository;
import com.app.RestDemo.repository.CustomerRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    public Customer addCustomer(AddCustomerInput addCustomerInput){
        Customer customer = new Customer();
        customer.setFirstName(addCustomerInput.getFirstName());
        customer.setLastName(addCustomerInput.getLastName());
        customer.setEmail(addCustomerInput.getEmail());

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(addCustomerInput.getBalance());
        bankAccount.setCurrency(addCustomerInput.getCurrency());

        bankAccountRepository.save(bankAccount);
        customer.setBankAccount(bankAccount);

        return customerRepository.save(customer);
    }

    public  Customer updateCustomer(UpdateCustomerInput updateCustomerInput , String id ){
        Customer customer = customerRepository.findById(id).get();
        String firstName = updateCustomerInput.getFirstName();
        String lastName = updateCustomerInput.getLastName();
        String email = updateCustomerInput.getEmail();

        if(firstName!=null) customer.setFirstName(firstName);
        if(lastName!=null) customer.setLastName(lastName);
        if(email!=null) customer.setEmail(email);

        return customerRepository.save(customer);

    }

    public List<Customer> addCustomers(List<AddCustomerInput> addCustomerInput){

        List<Customer> customerList = new ArrayList<>();

        for (AddCustomerInput customerInput  : addCustomerInput ) {
            Customer customer = new Customer();
            customer.setFirstName(customerInput.getFirstName());
            customer.setLastName(customerInput.getLastName());
            customer.setEmail(customerInput.getEmail());

            BankAccount bankAccount = new BankAccount();
            bankAccount.setBalance(customerInput.getBalance());
            bankAccount.setCurrency(customerInput.getCurrency());

            bankAccountRepository.save(bankAccount);
            customer.setBankAccount(bankAccount);

            customerList.add(customerRepository.save(customer));
        }

        return customerList;
    }


}

