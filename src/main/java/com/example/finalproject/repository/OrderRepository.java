package com.example.finalproject.repository;

import com.example.finalproject.model.Order;
import com.example.finalproject.model.OrderStatus;
import com.example.finalproject.model.Services;
import com.example.finalproject.model.ServicesTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o from Order o WHERE o.service = :service")
    List<Order> findByServiceType(ServicesTypes service);

    @Query("SELECT o from Order o where o.status = :status")
    List<Order> findByOrderStatus(OrderStatus status);

    @Query("SELECT o from Order o WHERE o.registerDate = :date")
    List<Order> findByRegisterDate(Date date);

    @Query("SELECT  o from Order o WHERE o.")
    List<Order> findOrderByCustomerId(Integer custId);

    @Query("from  Order order by suggestedPrice desc ")
    List<Order> ListOrdersByPrice();


}
