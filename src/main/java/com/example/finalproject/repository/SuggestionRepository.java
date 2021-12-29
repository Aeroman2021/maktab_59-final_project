package com.example.finalproject.repository;

import com.example.finalproject.model.Suggestion;
import com.example.finalproject.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion,Integer> {

    @Query("SELECT s.technician from Suggestion  s where s.id = :orderId order by s.suggestedPrice asc")
    List<Technician> findBestTechForOrder(Integer orderId);



}
