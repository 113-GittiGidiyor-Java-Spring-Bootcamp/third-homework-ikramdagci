package com.ikramdagci.thirdhomework.repository;

import com.ikramdagci.thirdhomework.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
