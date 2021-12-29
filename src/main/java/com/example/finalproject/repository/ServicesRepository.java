package com.example.finalproject.repository;

import com.example.finalproject.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

    @Query("SELECT s from Services s WHERE s.subServiceName = :name")
    Services findByName(String name);
}
