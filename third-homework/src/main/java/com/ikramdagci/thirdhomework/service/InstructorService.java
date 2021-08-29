package com.ikramdagci.thirdhomework.service;


import com.ikramdagci.thirdhomework.exception.StaffNotFoundException;
import com.ikramdagci.thirdhomework.model.Instructor;
import com.ikramdagci.thirdhomework.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorDao) {
        this.instructorRepository = instructorDao;
    }

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        instructorRepository.findAll().forEach(instructorList::add);
        return instructorList;
    }

    @Override
    public Instructor findById(Long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new StaffNotFoundException(id));
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
