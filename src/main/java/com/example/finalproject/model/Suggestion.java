package com.example.finalproject.model;

import com.example.finalproject.model.enums.SuggestionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "suggestions")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "register_date")
    private Date registerSuggestion;

    @Column(name = "suggested_price")
    private double suggestedPrice;

    @Column(name = "work_duration")
    private Integer workDuration;

    @Column(name = "start_time")
    private Integer startHour;

    @ManyToOne
    private Technician technician;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @Enumerated(EnumType.STRING)
    private SuggestionStatus status;
}
