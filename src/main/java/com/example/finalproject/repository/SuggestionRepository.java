package com.example.finalproject.repository;

import com.example.finalproject.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {

    List<Suggestion> findSuggestionByOrderIdOrderBySuggestedPriceAsc(Integer orderId);

}
