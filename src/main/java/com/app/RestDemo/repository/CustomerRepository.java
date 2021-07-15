package com.app.RestDemo.repository;

import com.app.RestDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,String> {
}
