package com.example.finalproject.model;

import com.example.finalproject.model.enums.OrderStatus;
import com.example.finalproject.model.enums.ServicesTypes;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ServicesTypes service;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String description;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<Services> services;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Column(name = "suggested_price")
    private double suggestedPrice;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "date_of_finishing_job")
    private Date endOfJob;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Suggestion> suggestions;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order orders = (Order) o;
        return Double.compare(orders.getSuggestedPrice(), getSuggestedPrice()) == 0 &&
                getService() == orders.getService() && getStatus() == orders.getStatus() &&
                Objects.equals(getRegisterDate(), orders.getRegisterDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getService(),
                getStatus(), getSuggestedPrice(), getRegisterDate());
    }
}
