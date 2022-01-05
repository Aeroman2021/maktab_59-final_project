package com.example.finalproject.service;

import com.example.finalproject.model.*;
import com.example.finalproject.model.enums.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SubServicesService subServicesService;

    @Autowired
    private MainServicesService mainServicesService;

    @Test
    public void testGetOrdersByStatus() {
        List<Order> orderList1 = orderService.getOrdersByStatus(OrderStatus.STARTED_THE_PROCESS);
        assertNotNull(orderList1);
    }

    @Test
    public void testListOrderByDate() {
        Date date1 = new Date(120, 12, 28);
        List<Order> resultList = orderService.getOrdersByRegisterDate(date1);
        assertNotNull(resultList);
    }

    @Test
    public void testListOrderByPrice() {
        List<Order> orderList = orderService.listOrdersBySuggestedPrice();
        double suggestedPrice = orderList.get(0).getSuggestedPrice();
        assertEquals(50000, suggestedPrice);
    }


    @Test
    public void submitAnOrder() {
        Address address = Address.builder()
                .Alley("Lale-19")
                .city("Busher")
                .houseNumber(7)
                .province("Bushehr")
                .street("Bisim")
                .build();
        Date date1 = new Date(122, 1, 4);
        Date date2 = new Date(122, 1, 15);
        Order order = Order.builder()
                .registerDate(date1)
                .startDate(date2)
                .suggestedPrice(70000)
                .address(address)
                .build();
        orderService.save(order);
        orderService.submitOrder(order, 3, 2);

    }




}
