package com.app.RestDemo.Controller;


import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.service.CustomerServiceWithRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class CustomerController {

    private static  final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerServiceWithRepo customerServiceWithRepo;

    @GetMapping("/version")
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.ok("1.0");
    }

    @GetMapping("/home")
    public ResponseEntity<String> home(){
      //  System.out.println("home in CustomerController");
        return new ResponseEntity<>("home", HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerServiceWithRepo.getCustomers(),HttpStatus.OK);
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id ) throws Exception {
        return  ResponseEntity.ok(customerServiceWithRepo.getCustomer(id));
    }

    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        customerServiceWithRepo.saveCustomer(customer);
        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable String id ){
        return ResponseEntity.ok(customerServiceWithRepo.updateCustomer(id,customer));
    }

    @DeleteMapping("/customer/{id}")
    public  ResponseEntity<String> deleteCustomer(@PathVariable String id ){
        customerServiceWithRepo.deleteCustomer(id);
        return  new ResponseEntity<>("Customer deleted - "+ id,HttpStatus.NO_CONTENT);
    }


}

