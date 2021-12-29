package com.example.finalproject.service;


import com.example.finalproject.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SuggestionServiceTest {

    @Autowired
    private SuggestionService suggestionService;

    @Autowired
    private TechnicianService technicianService;

    @Autowired
    private OrderService orderService;


    @Test
    public void testBestSuggestion(){
        Technician technician1 = new Technician();
        Technician technician2 = new Technician();
        Technician technician3 = new Technician();

        technician1.setFullName("Reza_Karimi");
        technician2.setFullName("Hasan_Akbari");
        technician3.setFullName("Bagher_Shakeri");

        technicianService.saveOrUpdate(technician1);
        technicianService.saveOrUpdate(technician2);
        technicianService.saveOrUpdate(technician3);

        Suggestion suggestion1 = Suggestion.builder()
                .suggestedPrice(42000)
                .technician(technician1)
                .build();

        suggestionService.saveOrUpdate(suggestion1);

        Suggestion suggestion2 = Suggestion.builder()
                .suggestedPrice(50000)
                .technician(technician2)
                .build();

        suggestionService.saveOrUpdate(suggestion2);

        Suggestion suggestion3 = Suggestion.builder()
                .suggestedPrice(30000)
                .technician(technician3)
                .build();

        suggestionService.saveOrUpdate(suggestion3);

        List<Suggestion> suggestionList = new ArrayList<>();
        suggestionList.add(suggestion1);
        suggestionList.add(suggestion2);
        suggestionList.add(suggestion3);

        Date todaysDate = new Date(120, 12, 28);

        Order order1 = Order.builder()
                .service(ServicesTypes.CLEANING)
                .status(OrderStatus.STARTED_THE_PROCESS)
                .endOfJob(todaysDate)
                .suggestions(suggestionList)
                .build();

        orderService.saveOrUpdate(order1);



        Technician thebestSuggestionForOrder = suggestionService.findThebestSuggestionForOrder(1);
        String technicianFullName = thebestSuggestionForOrder.getFullName();
        assertEquals(technicianFullName,"Bagher_Shakeri");


    }





}
