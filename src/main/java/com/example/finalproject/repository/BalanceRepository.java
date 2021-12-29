package com.example.finalproject.repository;

import com.example.finalproject.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface BalanceRepository extends JpaRepository<Balance,Integer> {

}
