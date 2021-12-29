package com.example.finalproject.service;

import com.example.finalproject.model.Transaction;
import com.example.finalproject.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService  {
    private final TransactionRepository transactionRepository;

    public void saveOrUpdate(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public void deleteById(Integer id){
        transactionRepository.deleteById(id);
    }

    public Optional<Transaction> findById(Integer id){
        return transactionRepository.findById(id);
    }

    public List<Transaction> findAll (){
        return  transactionRepository.findAll();
    }
}
