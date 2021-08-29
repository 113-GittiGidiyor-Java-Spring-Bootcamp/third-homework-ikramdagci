package com.ikramdagci.thirdhomework.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_instructor")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")
})
@Data
@NoArgsConstructor
public abstract class Instructor extends BaseSchoolStaff {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "salary")
    private double salary;
    @OneToMany(mappedBy = "instructor")
    private Set<Course> instructedCourses = new HashSet<>();



    public void addInstructedCourse(Course course) {
        instructedCourses.add(course);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "phoneNumber='" + phoneNumber + '\'' +
                ", instructedCourses=" + instructedCourses;
    }
}
