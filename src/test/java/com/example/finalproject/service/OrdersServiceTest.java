package com.example.finalproject.service;

import com.example.finalproject.model.Order;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.ServicesTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrderService orderService;


    @Test
    public void testSaveOrder_isOk() {

        Date todaysDate = new Date(120, 12, 28);
        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .registerDate(todaysDate)
                .build();
        orderService.saveOrUpdate(order1);

        Order result = orderService.findById(1).get();
        assertEquals(result.getService(), order1.getService());
    }


    @Test
    public void testFindBySrrviceTypes() {
        List<Order> orderList1 = orderService.findOrderByService(ServicesTypes.CLEANING);

        assertNotNull(orderList1);
    }

    @Test
    public void testGetOrdersByStatus() {
        Date todaysDate = new Date(120, 12, 28);
        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .suggestedPrice(45000)
                .endOfJob(todaysDate)
                .build();


        orderService.saveOrUpdate(order1);

        List<Order> orderList1 = orderService.getOrdersByStatus(OrderStatus.STARTED_THE_PROCESS);
        assertNotNull(orderList1);
    }

    @Test
    public void testListOrderByDate() {
        Date date1 = new Date(120, 12, 28);
        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .suggestedPrice(70000)
                .endOfJob(date1)
                .build();
        Date date2 = new Date(120, 12, 27);
        Order order2 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .suggestedPrice(60000)
                .endOfJob(date2)
                .build();

        orderService.saveOrUpdate(order1);
        orderService.saveOrUpdate(order2);

        List<Order> resultList = orderService.getOrdersByRegisterDate(date1);
        assertNotNull(resultList);
    }

    @Test
    public void testListOrderByPrice() {
        Date todaysDate = new Date(120, 12, 28);
        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .suggestedPrice(70000)
                .endOfJob(todaysDate)
                .build();

        Order order2 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .suggestedPrice(60000)
                .endOfJob(todaysDate)
                .build();

        orderService.saveOrUpdate(order1);
        orderService.saveOrUpdate(order2);

        List<Order> orderList = orderService.listOrdersBySuggestedPrice();
        double suggestedPrice = orderList.get(0).getSuggestedPrice();
        assertEquals(70000, suggestedPrice);

    }

}
