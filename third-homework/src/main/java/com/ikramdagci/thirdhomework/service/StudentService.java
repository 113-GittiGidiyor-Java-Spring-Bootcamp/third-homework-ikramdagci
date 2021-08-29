package com.ikramdagci.thirdhomework.service;

import com.ikramdagci.thirdhomework.exception.StaffNotFoundException;
import com.ikramdagci.thirdhomework.model.Address;
import com.ikramdagci.thirdhomework.model.Student;
import com.ikramdagci.thirdhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService implements BaseService<Student> {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Address findAddressById(Long id) {
        return findById(id).getAddress();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> maybeFoundStudent = studentRepository.findById(id);
        /*
        if(!maybeFoundStudent.isPresent()) {
            throw new StaffNotFoundException(id);
        }
        */
        return maybeFoundStudent.orElseThrow(() -> new StaffNotFoundException(id));
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findByGender(char gender) {
        return studentRepository.findByGender(gender);
    }

    public Student deleteByFullName(String fullName) {
        return studentRepository.deleteByFullName(fullName);
    }


}
