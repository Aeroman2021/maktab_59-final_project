package com.example.finalproject.repository;

import com.example.finalproject.model.Order;
import com.example.finalproject.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByStatus(OrderStatus status);
    List<Order> findOrderByRegisterDate(Date date);

}
