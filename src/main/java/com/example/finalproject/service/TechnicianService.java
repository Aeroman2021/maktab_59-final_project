package com.example.finalproject.service;

import com.example.finalproject.model.enums.RegisterStatus;
import com.example.finalproject.model.Technician;
import com.example.finalproject.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnicianService {
    private final TechnicianRepository technicianRepository;

    public void saveOrUpdate(Technician technician){
        technicianRepository.save(technician);
    }

    public void deleteById(Integer id){
        technicianRepository.deleteById(id);
    }

    public Optional<Technician> findById(Integer id){
        return technicianRepository.findById(id);
    }

    public List<Technician> findAll (){
        return  technicianRepository.findAll();
    }

    public List<Technician> filterTechniciansByProfession(String profession){
        return technicianRepository.findTechnicianByProfession(profession);
    }

    public List<Technician> filterTechniciansByRegisterDate(Date date){
        return technicianRepository.findTechnicianByRegisterDate(date);
    }

    public List<Technician> filterTechniciansByRegStatus(RegisterStatus status){
        return technicianRepository.findTechnicianByRegisterStatus(status);
    }




//    public void changePasswordById(Integer id,String password){
//        technicianRepository.updatePassById(id,password);
//    }
//
//    public void changePasswordByFullname(String fulname,String password){
//        technicianRepository.updatePassByFullname(fulname,password);
//    }
}
