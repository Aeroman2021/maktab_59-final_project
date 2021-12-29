package com.example.finalproject.model;


import com.example.finalproject.model.enums.ServicesTypes;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_service_name")
    private ServicesTypes servicesTypes;

    @Column(name = "sub_service_name")
    private String subServiceName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    private Double price;

    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Services)) return false;
        Services services = (Services) o;
        return getServicesTypes() == services.getServicesTypes() &&
                getSubServiceName().equals(services.getSubServiceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServicesTypes(), getSubServiceName());
    }
}
