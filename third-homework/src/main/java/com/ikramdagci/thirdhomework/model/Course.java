package com.ikramdagci.thirdhomework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_course")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "credit_score")
    private double creditScore;
    @ManyToOne
    @JoinColumn(name = "course_instructor_id")
    private Instructor instructor;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                ", instructor=" + instructor.getFullName() +
                '}';
    }
}
