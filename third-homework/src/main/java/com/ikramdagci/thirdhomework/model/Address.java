package com.ikramdagci.thirdhomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "zip_code", table = "t_address")
    private String zipCode;
    @Column(name = "city", table = "t_address")
    private String city;
    @Column(name = "street", table = "t_address")
    private String street;
    @Column(name = "house_number", table = "t_address")
    private int houseNumber;

    /**
     * Returns: printable format for plain text
     */
    public String toPlainText() {
        return street + ", " + city + ", " + houseNumber + ", " + zipCode;
    }
}
