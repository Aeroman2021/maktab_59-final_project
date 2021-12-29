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
    public void testFilterTechsByProff(){
        Technician technician1 = new Technician();
        technician1.setFullName("Mohsen_Malakouti");
        technician1.setProfession("Engineer");

        Technician technician2 = new Technician();
        technician2.setFullName("Ali_Ahmadi");
        technician2.setProfession("Cleaner");

        Technician technician3 = new Technician();
        technician3.setFullName("Reza_Ahmadi");
        technician3.setProfession("Engineer");

        technicianService.saveOrUpdate(technician1);
        technicianService.saveOrUpdate(technician2);
        technicianService.saveOrUpdate(technician3);

        Integer engineeringListSize = technicianService.filterTechniciansByProfession("Engineer").size();
        Integer cleaningListSize = technicianService.filterTechniciansByProfession("Cleaning").size();

        assertEquals(2, engineeringListSize);
    }


    @Test
    public void testFilterTechsByRegDate(){
        Date date1 = new Date(120, 12, 28);
        Date date2 = new Date(120, 12, 27);
        Technician technician1 = new Technician();
        technician1.setFullName("Mohsen_Malakouti");
        technician1.setProfession("Engineer");
        technician1.setRegisterDate(date1);

        Technician technician2 = new Technician();
        technician2.setFullName("Ali_Ahmadi");
        technician2.setProfession("Cleaner");
        technician2.setRegisterDate(date1);

        Technician technician3 = new Technician();
        technician3.setFullName("Reza_Ahmadi");
        technician3.setProfession("Engineer");
        technician3.setRegisterDate(date2);

        technicianService.saveOrUpdate(technician1);
        technicianService.saveOrUpdate(technician2);
        technicianService.saveOrUpdate(technician3);

        Integer resultList = technicianService.filterTechniciansByRegisterDate(date1).size();
        assertEquals(2, resultList);
    }

    @Test
    public void testFilterTechsByRegStatus(){
        Date date1 = new Date(120, 12, 28);
        Date date2 = new Date(120, 12, 27);
        Technician technician1 = new Technician();
        technician1.setFullName("Mohsen_Malakouti");
        technician1.setProfession("Engineer");
        technician1.setRegisterDate(date1);
        technician1.setStatus(RegisterStatus.PENDING);

        Technician technician2 = new Technician();
        technician2.setFullName("Ali_Ahmadi");
        technician2.setProfession("Cleaner");
        technician2.setRegisterDate(date1);
        technician2.setStatus(RegisterStatus.CONFIRMED);

        Technician technician3 = new Technician();
        technician3.setFullName("Reza_Ahmadi");
        technician3.setProfession("Engineer");
        technician3.setRegisterDate(date2);
        technician3.setStatus(RegisterStatus.CONFIRMED);

        technicianService.saveOrUpdate(technician1);
        technicianService.saveOrUpdate(technician2);
        technicianService.saveOrUpdate(technician3);

        Integer resultList = technicianService.filterTechniciansByRegStatus(RegisterStatus.CONFIRMED).size();
        assertEquals(2, resultList);
    }


}
