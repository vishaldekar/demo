package com.app.RestDemo.service;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @InjectMocks
    CustomerServiceWithRepoImpl customerServiceWithRepoImpl;

    @Mock
    CustomerRepository customerRepository;

    List<Customer> customerList;

    @BeforeEach
    void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        customerList = Arrays.asList(new Customer("1","A","A","A"),
                new Customer("1","A","A","A"));
    }

    @Test
    @DisplayName("Get all users ")
    void getCustomers() {

        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> list = customerServiceWithRepoImpl.getCustomers();
        assertEquals(2,list.size());
    }

    @Test
    @DisplayName("Should find customers by id ")
    void findCustomers(){
        Customer customer = new Customer("1","test","test","test");
        when(customerRepository.findById(anyString())).thenReturn(java.util.Optional.of(customer));
        Customer cust = customerServiceWithRepoImpl.getCustomer(anyString());
        assertEquals(customer.getEmail(),cust.getEmail());
        assertEquals(customer.getFirstName(),cust.getFirstName());
    }

    @Test
    @DisplayName("throwing an exception findbyid returns null ")
    void findCustomer_whenIdIsNull(){

        when(customerRepository.findById(anyString())).thenReturn(null);
        assertThrows(RuntimeException.class,
                ()->  customerServiceWithRepoImpl.getCustomer(anyString()));
    }

    @Test
    @DisplayName(" save customer")
    void saveCustomer(){
        Customer mockCustomer = new Customer("1","A","A","A");
        when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);

        Customer found = customerServiceWithRepoImpl.saveCustomer(mockCustomer);
        assertThat(found.getFirstName()).isSameAs(mockCustomer.getFirstName());
        verify(customerRepository).save(mockCustomer);
        assertEquals(mockCustomer.getEmail(),found.getEmail());
        assertEquals(mockCustomer.getFirstName(),found.getFirstName());
    }

    @Test
    @DisplayName("Should be able delete customer if user found")
    void deleteById(){
         Customer customer = new Customer("1","a","a","a");
         when(customerRepository.findById("1"))
                .thenReturn(java.util.Optional.of(customer));

        customerServiceWithRepoImpl.deleteCustomer("1");
        verify(customerRepository).deleteById(customer.getId());
    }

    @Test
    @DisplayName("Should be able to update customer ")
    void updateCustomer(){

        Customer customer = new Customer("1","a","a","a");

        given(customerRepository.findById(customer.getId())).willReturn(Optional.of(customer));
        customerServiceWithRepoImpl.updateCustomer(customer.getId(), customer);
        verify(customerRepository).save(customer);
        verify(customerRepository).findById(customer.getId());

    }

    @Test
    @DisplayName("Should throw exception when customer not found ")
    void userNotaFoundWhileUpdate(){
        Customer customer = new Customer("1","a","a","a");
        given(customerRepository.findById(customer.getId())).willReturn(null);
        assertThrows(RuntimeException.class,()->
                customerServiceWithRepoImpl.updateCustomer(customer.getId(),customer));
    }



}