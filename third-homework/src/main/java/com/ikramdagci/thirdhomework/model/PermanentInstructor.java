package com.ikramdagci.thirdhomework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_permanent_instructor")
@Data
@NoArgsConstructor
public class PermanentInstructor extends Instructor{

     @Column(name = "salary")
    private double salary;


    @Override
    public String toString() {
        return "PermanentInstructor{" +
                super.toString() +
                "salary=" + salary + "}";
    }
}
