package com.example.finalproject.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technicians")
public class Technician extends User {

    private Double credit;

    private Integer points;

    public Technician(Integer id, String fullName,Integer points) {
        super(id, fullName);
        this.points = points;
    }

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL)
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL)
    private List<Balance> transactions;

}
