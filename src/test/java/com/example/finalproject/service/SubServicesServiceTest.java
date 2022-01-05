package com.example.finalproject.service;



import com.example.finalproject.Exceptions.EntityNotFoundException;
import com.example.finalproject.model.Technician;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SubServicesServiceTest {

    @Autowired
    private SubServicesService subServicesService;

    @Autowired
    private MainServicesService mainServicesService;

    @Autowired
    private TechnicianService technicianService;


    @Test
    public void addSubServiceToMainService_isOk() {
        subServicesService.addSubServiceToTheMainServices(2, 5);

    }

    @Test
    public void addSubServiceToNoneExistMainService_ThrownExceptionIsOk(){
        assertThrows(EntityNotFoundException.class,
                ()->subServicesService.addSubServiceToTheMainServices(3, 5));
    }

    @Test
    public void addTechnecianToSubService_isOk(){
        List<Technician> technicians = technicianService.loadAll();
        subServicesService.addTechsToSubServices(2, technicians);
    }


}
