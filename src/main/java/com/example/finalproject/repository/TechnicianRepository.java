package com.example.finalproject.repository;

import com.example.finalproject.model.enums.RegisterStatus;
import com.example.finalproject.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Integer> {



    List<Technician> findTechniciansByRegisterDate(Date registerDate);
    List<Technician> findTechniciansByStatus(RegisterStatus status);



}
