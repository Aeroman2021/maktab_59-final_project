package com.example.finalproject.repository;

import com.example.finalproject.model.RegisterStatus;
import com.example.finalproject.model.Technician;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Integer> {

    @Query("SELECT t from Technician t where t.profession = :profession")
    List<Technician> findTechnicianByProfession(String profession);

    @Query("SELECT t from Technician t where t.registerDate = :registerDate")
    List<Technician> findTechnicianByRegisterDate(Date registerDate);

    @Query("SELECT t from Technician t where t.status = :status")
    List<Technician> findTechnicianByRegisterStatus(RegisterStatus status);


//    @Modifying
//    @Query("UPDATE Technician t SET t.password = :password WHERE t.id = :id")
//    void updatePassById(Integer id, String password);
//
//    @Modifying
//    @Query("UPDATE Technician t SET t.password = :password WHERE t.fullName = :fullname")
//    void updatePassByFullname(String fullname,String passwprd);

}
