package com.example.finalproject.service;

import com.example.finalproject.model.MainServices;
import com.example.finalproject.model.Order;
import com.example.finalproject.repository.MainServicesRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MainServicesService extends AbstractCRUD<MainServices,Integer> {


    private final MainServicesRepository servicesRepository;

    @PostConstruct
    public void init(){
        setJpaRepository(servicesRepository);
    }

}
