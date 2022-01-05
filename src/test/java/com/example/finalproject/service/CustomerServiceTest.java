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
    public void testChangePassword() {
        Customer customer = customerService.loadById(1);
        customerService.changePasswordById(1, "789456");
        assertEquals("789456", customer.getPassword());

    }

}
