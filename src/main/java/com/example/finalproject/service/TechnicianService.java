package com.example.finalproject.service;

import com.example.finalproject.model.Customer;
import com.example.finalproject.model.Order;
import com.example.finalproject.model.enums.RegisterStatus;
import com.example.finalproject.model.Technician;
import com.example.finalproject.repository.TechnicianRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnicianService extends AbstractCRUD<Technician,Integer> {


    private final TechnicianRepository technicianRepository;

    @PostConstruct
    public void init(){
        setJpaRepository(technicianRepository);
    }

    public List<Technician> filterTechniciansByRegisterDate(Date date){
        return technicianRepository.findTechniciansByRegisterDate(date);
    }

    public List<Technician> filterTechniciansByRegStatus(RegisterStatus status){
        return technicianRepository.findTechniciansByStatus(status);
    }

    public List<Technician> listTechsOrderByPoints() {
        return technicianRepository.findAll(Sort.by(Sort.Direction.ASC, "points"));
    }

}
