package com.example.finalproject.repository;

import com.example.finalproject.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

    @Query("SELECT s from Services s WHERE s.subServiceName = :name")
    Services findByName(String name);


    @Query("SELECT s from Services s WHERE s.order.id = :orderId")
    List<Services> findServicesByOrderId(Integer orderId);

}
