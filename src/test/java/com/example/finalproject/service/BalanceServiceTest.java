package com.example.finalproject.service;


import com.example.finalproject.model.Balance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BalanceServiceTest {

    @Autowired
    BalanceService balanceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TechnicianService technicianService;


    @Test
    public void saveBalance_isOK() {
        Date todaysDate = new Date(120, 11, 30);
        Balance balance = new Balance();

        balance.setTransactionDate(todaysDate);

        balanceService.saveOrUpdate(balance,1,1);
        assertNotNull(balance);
    }

    @Test
    public void updateBalance_isOk(){
        Balance balance = balanceService.loadById(1);
        balanceService.saveOrUpdate(balance,20000d,1,1);
        assertEquals(30000,balance.getCustomerBalance());
    }


}
