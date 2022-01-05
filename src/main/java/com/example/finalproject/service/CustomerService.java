package com.example.finalproject.service;

import com.example.finalproject.Exceptions.DuplicateEntityException;
import com.example.finalproject.model.Customer;
import com.example.finalproject.repository.CustomerRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CustomerService extends AbstractCRUD<Customer, Integer> {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        setJpaRepository(customerRepository);
    }


    public Customer findByName(String fullname) {
        return customerRepository.findCustomerByFullName(fullname);
    }


    @Transactional
    public void changePasswordById(Integer id, String password) {
        Customer customer = customerRepository.findById(id).get();
        customer.setPassword(password);
        super.save(customer);

    }

    @Transactional
    public Customer save(Customer customer) {
        if (!customerIsValid(customer))
            throw new DuplicateEntityException("The customer with given Email exist in the Database");

        return super.save(customer);
    }


    public boolean customerIsValid(Customer customer) {
        return (!emailIsExist(customer) && passwordIsValid(customer));
    }

    public boolean emailIsExist(Customer customer) {
        for (Customer currentCustomer : customerRepository.findAll()) {
            if (currentCustomer.getEmail().equals(customer.getEmail()))
                return true;
        }
        return false;
    }

    public boolean passwordIsValid(Customer customer) {
        if (customer.getPassword() == null)
            return false;

        String regex = "^(?=.*[0-9])(?=.*[a-z,A-Z]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customer.getPassword());
        return !matcher.matches();
    }
}
