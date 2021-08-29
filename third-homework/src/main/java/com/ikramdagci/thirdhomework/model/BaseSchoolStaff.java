package com.ikramdagci.thirdhomework.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_school_staff")
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "staff_id"))
@Data
@NoArgsConstructor
public abstract class BaseSchoolStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Embedded
    Address address;

    @Override
    public String toString() {
        return "staffId=" + id +
                ", fullName='" + fullName + '\'' +
                ", address=" + address;
    }
}
