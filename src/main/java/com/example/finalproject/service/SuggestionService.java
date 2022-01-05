package com.example.finalproject.service;

import com.example.finalproject.model.*;
import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.SuggestionStatus;
import com.example.finalproject.repository.SuggestionRepository;
import com.example.finalproject.repository.CustomRepositories.SuggestionRepositoryCustom;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService extends AbstractCRUD<Suggestion, Integer> implements SuggestionRepositoryCustom {

    private final SuggestionRepository suggestionRepository;
    private final OrderService orderService;
    private final TechnicianService technicianService;

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        setJpaRepository(suggestionRepository);
    }

    @Transactional
    public void saveOrUpdate(Suggestion suggestion, Integer orderId, Integer technicianId) {
        Order order = orderService.loadById(orderId);
        Technician technician = technicianService.loadById(technicianId);
        suggestion.setOrder(order);
        suggestion.setTechnician(technician);
        suggestion.setStatus(SuggestionStatus.Accepted);
        super.save(suggestion);
    }


    public Boolean technicianIsQualifyForOrder(Order order, Technician technician) {
        SubServices subServices = order.getSubServices();
        return subServices.getTechnicians().contains(technician);
    }

    @Transactional
    public void submitSuggestionByTechs(Suggestion suggestion, Integer technicianId, Integer orderId) {
        Order order = orderService.loadById(orderId);
        Technician technician = technicianService.loadById(technicianId);
        if (technicianIsQualifyForOrder(order, technician)) {
            suggestion.setTechnician(technician);
            suggestion.setOrder(order);
            order.setStatus(OrderStatus.PENDING_FOR_SELECTING_TECHNICIAN);
            suggestion.setStatus(SuggestionStatus.Pending);
            super.update(suggestion);
        }
    }

    @Transactional
    public void AcceptSuggestionByCust(Integer suggestionId){
        Suggestion suggestion = loadById(suggestionId);
        suggestion.setStatus(SuggestionStatus.Accepted);
        super.update(suggestion);
    }

    @Override
    public void listTechBasedOnPriceSuggestion(Integer order) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Suggestion> suggestions = cq.from(Suggestion.class);
        Join<Suggestion, Technician> technicians = suggestions.join("technician");
        CriteriaQuery<Object[]> criteriaQuery = cq.multiselect(technicians.get("id"), technicians.get("fullName"),
                        suggestions.get("suggestedPrice"))
                .orderBy(cb.asc(suggestions.get("suggestedPrice")))
                .groupBy(technicians);
        List<Object[]> objects = em.createQuery(cq).getResultList();
        System.out.println("ID" + " | " + "fullName" + " | " + "Suggestion_price");
        for (Object[] object : objects) {
            System.out.println(object[0] + " | " + object[1] + " | " + object[2]);
        }
        System.out.println(objects.get(0)[1] + " suggested the lowest price.");
    }

    @Override
    public void listTechBasedOnPoints(Integer orderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Suggestion> suggestions = cq.from(Suggestion.class);
        Join<Suggestion, Technician> technicians = suggestions.join("technician");
        cq.multiselect(technicians.get("id"), technicians.get("fullName"), technicians.get("points"))
                .orderBy(cb.desc(technicians.get("points")));
        List<Object[]> objects = em.createQuery(cq).getResultList();
        System.out.println("ID" + " | " + "full_name" + " | " + "points");
        for (Object[] object : objects) {
            System.out.println(object[0] + " | " + object[1] + " | " + object[2]);
        }
        System.out.println(objects.get(0)[1] + " has the max point.");
    }


}
