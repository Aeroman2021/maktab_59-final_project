package com.example.finalproject.service;


import com.example.finalproject.model.Balance;
import com.example.finalproject.model.Order;
import com.example.finalproject.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceService {
    private final BalanceRepository balanceRepository;


    public void saveOrUpdate(Balance balance){
        balanceRepository.save(balance);
    }

    public void deleteById(Integer id){
        balanceRepository.deleteById(id);
    }

    public Optional<Balance> findById(Integer id){
        return balanceRepository.findById(id);
    }

    public List<Balance> findAll (){
        return  balanceRepository.findAll();
    }



}
