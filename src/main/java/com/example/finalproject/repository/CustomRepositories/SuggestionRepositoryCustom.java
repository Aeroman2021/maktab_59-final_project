package com.example.finalproject.repository.CustomRepositories;

import com.example.finalproject.model.Technician;

import java.util.List;

public interface SuggestionRepositoryCustom {

    void listTechBasedOnPriceSuggestion(Integer order);
    void listTechBasedOnPoints(Integer orderId);

}
