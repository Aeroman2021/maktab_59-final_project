package com.example.finalproject.service;


import com.example.finalproject.model.Order;
import com.example.finalproject.model.Services;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.ServicesTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ServicesServiceTest {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testFindServicesByOerderId(){
        Date todaysDate = new Date(120, 12, 28);

        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .endOfJob(todaysDate)
                .build();

        orderService.saveOrUpdate(order1);

        Optional<Order> order = orderService.findById(1);
        Order orderFirts = order.get();

        Services services = Services.builder()
                .order(orderFirts)
                .build();

        servicesService.saveOrUpdate(services);



        List<Services> resultList = servicesService.findServiByOrderId(1);
        assertNotNull(resultList);
    }
}
