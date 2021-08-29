package com.ikramdagci.thirdhomework.repository;

import com.ikramdagci.thirdhomework.model.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor,Long> {

//    @Query("SELECT * FROM t_instructor ORDER BY salary DESC LIMIT 3")
//    List<Instructor> findTop3BySalary();
}
