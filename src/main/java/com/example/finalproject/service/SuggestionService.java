package com.example.finalproject.service;

import com.example.finalproject.model.Suggestion;
import com.example.finalproject.model.Technician;
import com.example.finalproject.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final SuggestionRepository suggestionRepository;

    public void saveOrUpdate(Suggestion suggestion){
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
