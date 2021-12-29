package com.example.finalproject.service;

import com.example.finalproject.model.Order;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.ServicesTypes;
import com.example.finalproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void saveOrUpdate(Order order){
        orderRepository.save(order);
    }

    public void deleteById(Integer id){
        orderRepository.deleteById(id);
    }

    public Optional<Order> findById(Integer id){
        return orderRepository.findById(id);
    }

    public List<Order> findAll (){
        return  orderRepository.findAll();
    }

    public List<Order> findOrderByService(ServicesTypes serviceType){
        return orderRepository.findByServiceType(serviceType);
    }

    public List<Order> getOrdersByStatus(OrderStatus status){
        return orderRepository.findByOrderStatus(status);
    }

    public List<Order> getOrdersByRegisterDate(Date status){
        return orderRepository.findByRegisterDate(status);
    }

    public List<Order> listOrdersBySuggestedPrice(){
        return orderRepository.ListOrdersByPrice();
    }



}
