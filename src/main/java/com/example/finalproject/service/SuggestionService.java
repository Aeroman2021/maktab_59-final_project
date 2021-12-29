package com.example.finalproject.service;

import com.example.finalproject.model.Order;
import com.example.finalproject.model.Suggestion;
import com.example.finalproject.model.Technician;
import com.example.finalproject.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final SuggestionRepository suggestionRepository;

    private final OrderService orderService;
    private final TechnicianService technicianService;

    @Transactional
    public void saveOrUpdate(Suggestion suggestion){
        suggestionRepository.save(suggestion);
    }

    @Transactional
    public void saveOrUpdate(Suggestion suggestion,Integer orderId,Integer technecianId){
        Order order = orderService.findById(orderId).get();
        Technician technician = technicianService.findById(technecianId).get();
        suggestion.setOrder(order);
        suggestion.setTechnician(technician);
        suggestionRepository.save(suggestion);
    }

    public void deleteById(Integer id){
        suggestionRepository.deleteById(id);
    }

    public Optional<Suggestion> findById(Integer id){
        return suggestionRepository.findById(id);
    }

    public List<Suggestion> findAll (){
        return  suggestionRepository.findAll();
    }

    public Technician findThebestSuggestionForOrder(Integer orderId){
        List<Technician> sortedListBasedPrice = suggestionRepository.findBestTechForOrder(orderId);
        return sortedListBasedPrice.get(0);
    }
}
