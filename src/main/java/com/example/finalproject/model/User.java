package com.example.finalproject.model;

import com.example.finalproject.model.enums.RegisterStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@MappedSuperclass
@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public  class User {

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
    private RegisterStatus status = RegisterStatus.NEW;

    public User(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User person = (User) o;
        return getFullName().equals(person.getFullName()) &&
                getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getEmail());
    }
}
