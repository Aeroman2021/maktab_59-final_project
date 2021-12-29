package com.example.finalproject.repository;

import com.example.finalproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query("SELECT c from Customer c where c.fullName=:fullname")
    public Customer findByFullName(String fullname);


    @Modifying
    @Query("UPDATE Customer c SET c.password = :password WHERE c.id = :id")
    void updatePassById(Integer id, String password);


//
//    @Modifying
//    @Query("UPDATE Customer c SET c.password = :password WHERE c.fullName = :fullname")
//    void updatePassByFullname(String fullname,String passwprd);


}
