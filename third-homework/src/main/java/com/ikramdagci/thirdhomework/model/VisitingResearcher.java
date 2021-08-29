package com.ikramdagci.thirdhomework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_visiting_researcher")
@Data
@NoArgsConstructor
public class VisitingResearcher extends Instructor{

    @Column(name = "hours_worked")
    private int hoursWorked;
    private static final double hourlySalary = 205.0;

    public double calculateTotalSalary() {
        return hoursWorked * hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                super.toString() +
                "hoursWorked=" + hoursWorked +
                "}";
    }
}
