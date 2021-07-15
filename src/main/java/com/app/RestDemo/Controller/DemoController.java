package com.app.RestDemo.Controller;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DemoController {

    @Autowired
    private CustomerService service ;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable String id ) throws Exception {
        return service.getCustomer(id) ;
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer){
        service.saveCustomer(customer);
        return  "Success";
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@RequestBody Customer customer,@PathVariable String id ){
        service.saveCustomer(customer);
        return  "SUCESS";
    }

    @DeleteMapping("/customer/{id}")
    public  String deleteCustomer(@PathVariable int id ){
        service.deleteCustomer(id);
        return  "Customer deleted - "+ id;
    }

}
