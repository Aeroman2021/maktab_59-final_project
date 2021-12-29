package com.example.finalproject.repository;

import com.example.finalproject.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Balance, Integer> {



}
