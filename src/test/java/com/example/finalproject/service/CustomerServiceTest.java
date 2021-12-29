package com.example.finalproject.service;


import com.example.finalproject.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testSavePerson(){
        Customer customer = new Customer();
        customer.setFullName("Mohsen_Malakouti");


        customerService.saveOrUpdate(customer);

        Customer customer1 = customerService.findByName("Mohsen_Malakouti");
        assertEquals(customer.getFullName(),customer1.getFullName());
    }

    @Test
    public void testupdate(){
        Optional<Customer> customer = customerService.findById(1);
        customer.get().setPassword("123456");
        customerService.saveOrUpdate(customer.get());
    }

    @Test
    public  void testChangePassword(){
        customerService.changePasswordById(1,"789456");
    }

}
