package com.example.finalproject.service;


import com.example.finalproject.model.Order;
import com.example.finalproject.model.Suggestion;
import com.example.finalproject.model.Technician;
import com.example.finalproject.model.enums.SuggestionStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


//    @Test
//    public void testBestSuggestion(){
//        Suggestion result = suggestionService.findThebestSuggestionForOrder(1);
//        String fullName = result.getTechnician().getFullName();
//        assertEquals("Reza_Ahmadi",fullName);
//    }

    @Test
    public void testSubmitSuggestion_isOK() {
        Suggestion suggestion = Suggestion
                .builder()
                .suggestedPrice(70000)
                .startHour(17)
                .workDuration(36)
                .build();
        Suggestion suggestion1 = suggestionService.save(suggestion);
        suggestionService.submitSuggestionByTechs(suggestion1, 1, 2);
    }

    @Test
    public void testListSuggestionsBasedOnPrice_isOK() {
        suggestionService.listTechBasedOnPriceSuggestion( 2);
    }

    @Test
    public void testListBasedOnPoints_isOK() {
       suggestionService.listTechBasedOnPoints(2);
    }

    @Test
    public void testAcceptSuggestion_isOK(){
        suggestionService.AcceptSuggestionByCust(2);
        SuggestionStatus status = suggestionService.loadById(2).getStatus();
        assertEquals(SuggestionStatus.Accepted,status);

    }



}
