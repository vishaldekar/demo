package com.app.RestDemo.Controller;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.service.CustomerServiceWithRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(Runner.class)
class CustomerControllerTest {


    @Mock
    CustomerServiceWithRepo customerServiceWithRepo;

    @InjectMocks
    CustomerController customerController ;

    List<Customer> customerList;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        customerList = new ArrayList<>();
        customerList.add(new Customer("2", "user2", "User2","User2"));
        customerList.add(new Customer("3", "user3", "User3","User3"));
        customerList.add(new Customer("1", "user1", "User1","User1"));
    }

    @Test
    @DisplayName("testing home ")
    void Home(){
        ResponseEntity<String> responseEntity = customerController.home();
        System.out.println(responseEntity.getBody());
    }

    @Test
    @DisplayName(" Demo for home ")
    void getCustomers() throws Exception {
        when(customerServiceWithRepo.getCustomers()).thenReturn(customerList);
        ResponseEntity<List<Customer>> responseEntity = customerController.getCustomers();
        assertThat(responseEntity.getStatusCode().toString()).isEqualTo("200 OK");
        assertEquals(responseEntity.getBody(),customerList);
    }

    @Test
    @DisplayName("Delete customer by Id  ")
    void deleteUserById() throws  Exception{
        Customer customer = new Customer("1","A","A","A");
        doNothing().when(customerServiceWithRepo).deleteCustomer(customer.getId());
        ResponseEntity<String> response = customerController.deleteCustomer(customer.getId());
        assertEquals(response.getStatusCode().value(),204);
        assertEquals(response.getBody(),"Customer deleted - "+customer.getId());
    }



    @Test
    @DisplayName("find customer by id ")
    void  findCustomerById() throws  Exception{
        Customer customer = new Customer("1","test","test","test");
        given(customerServiceWithRepo.getCustomer(customer.getId())).willReturn(customer);
        ResponseEntity<Customer> response = customerController.getCustomerById(customer.getId());
        assertEquals(response.getStatusCode().value(),200);
        assertEquals(response.getBody(),customer);
    }


    @Test
    @DisplayName("update customer ")
    void updateCustomer() throws Exception {
        Customer customer = new Customer("1","test","test","test");
        given(customerServiceWithRepo.updateCustomer(customer.getId(), customer)).willReturn(customer);
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<Customer> response = customerController.updateCustomer(customer,customer.getId());
        assertEquals(response.getStatusCode().value(),200);
        assertEquals(customer.getFirstName(),response.getBody().getFirstName());
        assertEquals(customer.getLastName(),response.getBody().getLastName());
        assertEquals(customer.getEmail(),response.getBody().getEmail());

    }


    @Test
    @DisplayName("add customer ")
    void addCustomer() throws Exception{
        Customer customer = new Customer("1","test","test","test");
        given(customerServiceWithRepo.updateCustomer(customer.getId(), customer)).willReturn(customer);
        ResponseEntity<String> response = customerController.addCustomer(customer);
        assertEquals(response.getStatusCode().value(),201);
        assertEquals(response.getBody(),"Success");
    }


    /*

    @MockBean
    private CustomerServiceWithRepo customerServiceWithRepo;

    @Autowired
    private MockMvc mockMvc;

    List<Customer> customerList;

    @BeforeEach
    void setUp(){
        this.customerList = new ArrayList<>();
        this.customerList.add(new Customer("2", "user2", "User2","User2"));
        this.customerList.add(new Customer("3", "user3", "User3","User3"));
        this.customerList.add(new Customer("1", "user1", "User1","User1"));
    }

    @Test
    @DisplayName("test for /home ")
    void getHome() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/test/home"))
                .andExpect(status().isOk())
                .andExpect(content().string("home"));
    }

    @Test
    @DisplayName("Get all customers  ")
    void getCustomer() throws  Exception{
        given(customerServiceWithRepo.getCustomers()).willReturn(customerList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/customer"))
            .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }


    @Test
    @DisplayName("Delete customer by Id  ")
    void deleteUserById() throws  Exception{
        Customer customer = new Customer("1","A","A","A");
        doNothing().when(customerServiceWithRepo).deleteCustomer(customer.getId());
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/test/customer/" + customer.getId().toString())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("find customer by id ")
    void  findCustomerById() throws  Exception{
        Customer customer = new Customer("1","test","test","test");

        given(customerServiceWithRepo.getCustomer(customer.getId())).willReturn(customer);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/customer/" + customer.getId().toString())
        .contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is(customer.getFirstName())));
    }

    @Test
    @DisplayName("update customer ")
    void updateCustomer() throws Exception {
        Customer customer = new Customer("1","test","test","test");
        given(customerServiceWithRepo.updateCustomer(customer.getId(), customer)).willReturn(customer);
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/test/customer/" + customer.getId().toString())
            .content(mapper.writeValueAsString(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Success"));
    }

    @Test
    @DisplayName("add customer ")
    void addCustomer() throws Exception{
        Customer customer = new Customer("1","test","test","test");
        given(customerServiceWithRepo.updateCustomer(customer.getId(), customer)).willReturn(customer);
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/test/customer")
                .content(mapper.writeValueAsString(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("Success"));
    }

    */
}