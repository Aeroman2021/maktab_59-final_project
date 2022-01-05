package com.example.finalproject.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {
    private String province;
    private String city;
    private String street;
    private String Alley;
    private Integer houseNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getProvince(), address.getProvince()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getAlley(), address.getAlley()) &&
                Objects.equals(getHouseNumber(), address.getHouseNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProvince(), getCity(), getStreet(), getAlley(), getHouseNumber());
    }
}
