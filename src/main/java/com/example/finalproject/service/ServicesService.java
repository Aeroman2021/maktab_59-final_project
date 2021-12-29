package com.example.finalproject.service;

import com.example.finalproject.model.Services;
import com.example.finalproject.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ServicesService {
    private final ServicesRepository serviceTypeRepository;


    public void saveOrUpdate(Services service){
       serviceTypeRepository.save(service);
    }

    public void delete(Services service){
        serviceTypeRepository.delete(service);
    }

    public Optional<Services> findById(Integer id){
        return serviceTypeRepository.findById(id);
    }

    public List<Services> findAll(){
        return serviceTypeRepository.findAll();
    }

    public Services findserviceByName(String serviceName){
        return serviceTypeRepository.findByName(serviceName);
    }

}
