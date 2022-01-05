package com.example.finalproject.service;


import com.example.finalproject.model.enums.RegisterStatus;
import com.example.finalproject.model.Technician;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TechnicianSrviceTest {

    @Autowired
    private TechnicianService technicianService;



    @Test
    public void testFilterTechsByRegDate(){
        Date date1 = new Date(122, 1, 1);

        Integer resultList = technicianService.filterTechniciansByRegisterDate(date1).size();
        assertEquals(2, resultList);
    }

    @Test
    public void testFilterTechsByRegStatus(){
        Integer resultList = technicianService.filterTechniciansByRegStatus(RegisterStatus.CONFIRMED).size();
        assertEquals(2, resultList);
    }


}
