package com.example.finalproject.service;

import com.example.finalproject.Exceptions.UnableToSubmitOrderException;
import com.example.finalproject.model.Customer;
import com.example.finalproject.model.Order;
import com.example.finalproject.model.SubServices;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.repository.OrderRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService extends AbstractCRUD<Order, Integer> {

    private final OrderRepository orderRepository;
    private final BalanceService balanceService;
    private final CustomerService customerService;
    private final SubServicesService subServicesService;

    @PostConstruct
    public void init() {
        setJpaRepository(orderRepository);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrdersByRegisterDate(Date status) {
        return orderRepository.findOrderByRegisterDate(status);
    }

    public List<Order> listOrdersBySuggestedPrice() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "suggestedPrice"));
    }


    @Transactional
    public void submitOrder(Order order, Integer customerId, Integer subServicesId) {
        if (balanceService.customerIsAbleTooAffordOrder(subServicesId,customerId)) {
            Customer customer = customerService.loadById(customerId);
            SubServices subServices = subServicesService.loadById(subServicesId);
            order.setCustomer(customer);
            order.setSubServices(subServices);
            order.setStatus(OrderStatus.PENDING_FOR_TECHNICIAN_SUGGESTION);
            super.update(order);
        } else
            throw new UnableToSubmitOrderException("Unable to submit Order!");
    }


}
