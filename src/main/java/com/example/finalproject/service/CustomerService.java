package com.example.finalproject.service;

import com.example.finalproject.model.Customer;
import com.example.finalproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService  {

    private final CustomerRepository customerRepository;

    public void saveOrUpdate(Customer customer){
        customerRepository.save(customer);

    }

    public void deleteById(Integer id){
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findById(Integer id){
        return customerRepository.findById(id);
    }

    public Customer findByName(String fullname){
        return customerRepository.findByFullName(fullname);
    }

    public List<Customer> findAll (){
        return  customerRepository.findAll();
    }


    @Transactional
    public void changePasswordById(Integer id,String password){
        customerRepository.updatePassById(id,password);
    }
//
//    public void changePasswordByFullname(String fulname,String password){
//        customerRepository.updatePassByFullname(fulname,password);
//    }
}
