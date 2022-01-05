package com.example.finalproject.service;


import com.example.finalproject.model.Balance;
import com.example.finalproject.model.Customer;
import com.example.finalproject.model.SubServices;
import com.example.finalproject.model.Technician;
import com.example.finalproject.repository.BalanceRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class BalanceService extends AbstractCRUD<Balance, Integer> {

    private final BalanceRepository balanceRepository;

    private final CustomerService customerService;

    private final TechnicianService technicianService;

    private final SubServicesService subServicesService;

    @PostConstruct
    public void init() {
        setJpaRepository(balanceRepository);
    }


    @Transactional
    public void saveOrUpdate(Balance balance, Integer custID, Integer techID) {
        Customer customer = customerService.loadById(custID);
        Technician technician = technicianService.loadById(techID);

        balance.setCustomer(customer);
        balance.setTechnician(technician);

        super.save(balance);
    }

    @Transactional
    public void saveOrUpdate(Balance balance, Double cost, Integer custID, Integer techID) {
        Customer customer = customerService.loadById(custID);
        Technician technician = technicianService.loadById(techID);

        Double custUpdatedCredit = customer.getCredit() - cost;
        customer.setCredit(custUpdatedCredit);
        customerService.save(customer);

        Double techUpdatedCredit = technician.getCredit() + cost;
        technician.setCredit(techUpdatedCredit);
        technicianService.save(technician);

        balance.setCustomerBalance(custUpdatedCredit);
        balance.setTechnecianBalance(techUpdatedCredit);

        super.save(balance);
    }

    public boolean customerIsAbleTooAffordOrder(Integer subServiceID, Integer customerId) {
        Customer customer = customerService.loadById(customerId);
        SubServices subServices = subServicesService.loadById(subServiceID);
        return customer.getCredit() > subServices.getPrice();
    }
}
