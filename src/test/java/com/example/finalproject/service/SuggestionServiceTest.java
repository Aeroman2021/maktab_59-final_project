package com.example.finalproject.service;


import com.example.finalproject.model.*;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.ServicesTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
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
    public void testSaveSuggestion(){

//        Order foundOrder = orderService.findById(1).get();
//        Technician technician1 = technicianService.findById(1).get();
//        Technician technician2 = technicianService.findById(2).get();
//        Technician technician3 = technicianService.findById(3).get();


        Suggestion suggestion1 = Suggestion.builder()
                .suggestedPrice(47000)
                .build();


        Suggestion suggestion2 = Suggestion.builder()
                .suggestedPrice(49000)
                .build();

        Suggestion suggestion3 = Suggestion.builder()
                .suggestedPrice(32000)
                .build();

        suggestionService.saveOrUpdate(suggestion1,1,1);
        suggestionService.saveOrUpdate(suggestion2,1,2);
        suggestionService.saveOrUpdate(suggestion3,1,3);



//        Suggestion suggestion2 = Suggestion.builder()
//                .suggestedPrice(50000)
//                .order(foundOrder)
//                .technician(technician2)
//                .build();
//
//        suggestionService.saveOrUpdate(suggestion2);
//
//        Suggestion suggestion3 = Suggestion.builder()
//                .suggestedPrice(30000)
//                .technician(technician3)
//                .order(foundOrder)
//                .build();
//
//        suggestionService.saveOrUpdate(suggestion3);
    }


    @Test
    public void testBestSuggestion(){
        Technician thebestSuggestionForOrder = suggestionService.findThebestSuggestionForOrder(1);
        String technicianFullName = thebestSuggestionForOrder.getFullName();
        assertEquals("Reza_Ahmadi",technicianFullName);
    }
}
