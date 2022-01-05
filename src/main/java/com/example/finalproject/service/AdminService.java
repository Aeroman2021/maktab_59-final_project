package com.example.finalproject.service;

import com.example.finalproject.model.Admin;
import com.example.finalproject.repository.AdminRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class AdminService extends AbstractCRUD<Admin,Integer> {

    private final AdminRepository adminRepository;

    @PostConstruct
    public void init(){
        setJpaRepository(adminRepository);
    }

}
