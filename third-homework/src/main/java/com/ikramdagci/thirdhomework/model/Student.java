package com.ikramdagci.thirdhomework.model;

import com.ikramdagci.thirdhomework.model.enumeration.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "t_student")
@Data
@NoArgsConstructor
public class Student extends BaseSchoolStaff {

    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(fetch = FetchType.EAGER) // show_sql property is true so printable format is corrupted with default fetchType(FetchType.LAZY for @ManyToMany)
    @JoinTable(name = "t_student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "birthDate=" + birthDate +
                ", gender=" + gender +
                ", courses=" + courses +
                '}';
    }
}
