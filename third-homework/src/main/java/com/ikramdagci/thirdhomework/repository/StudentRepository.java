package com.ikramdagci.thirdhomework.repository;

import com.ikramdagci.thirdhomework.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findByGender(char gender);
    Student deleteByFullName(String fullName);
}
