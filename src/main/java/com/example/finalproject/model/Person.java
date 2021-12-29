package com.example.finalproject.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String email;

    private String username;

    private String password;

    @Column(name = "register_date")
    private Date registerDate;

    @Enumerated(EnumType.STRING)
    private RegisterStatus status;

    private Double credit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getFullName().equals(person.getFullName()) &&
                getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getEmail());
    }
}
