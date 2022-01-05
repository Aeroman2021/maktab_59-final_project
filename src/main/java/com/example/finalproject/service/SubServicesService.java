package com.example.finalproject.service;

import com.example.finalproject.model.MainServices;
import com.example.finalproject.model.SubServices;
import com.example.finalproject.model.Technician;
import com.example.finalproject.model.enums.MainServicesName;
import com.example.finalproject.repository.SubServiceRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubServicesService extends AbstractCRUD<SubServices,Integer> {

    private final SubServiceRepository subServiceRepository;

    private final MainServicesService mainServicesService;

    private final TechnicianService technicianService;

    @PostConstruct
    public void  init(){
        setJpaRepository(subServiceRepository);
    }

    @Transactional
    public void addSubServiceToTheMainServices(Integer mainServiceId, Integer subServiceId){
        SubServices subServices = super.loadById(subServiceId);
        MainServices mainServices = mainServicesService.loadById(mainServiceId);
        subServices.setMainServices(mainServices);
        super.update(subServices);
    }

    public void addTechsToSubServices(Integer subServiceId, List<Technician> technicianList){
        SubServices subServices = super.loadById(subServiceId);
        subServices.setTechnicians(technicianList);
        super.save(subServices);
    }

}
