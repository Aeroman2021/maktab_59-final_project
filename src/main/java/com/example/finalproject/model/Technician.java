package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "technicians")
public class Technician extends Person {

    private String profession;

    @OneToMany(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "technician_id")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy ="technician", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
