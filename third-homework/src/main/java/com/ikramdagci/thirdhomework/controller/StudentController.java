package com.ikramdagci.thirdhomework.controller;


import com.ikramdagci.thirdhomework.model.Student;
import com.ikramdagci.thirdhomework.model.enumeration.Gender;
import com.ikramdagci.thirdhomework.service.StudentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Data
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        return new ResponseEntity<Student>(studentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(Student student) {
        return new ResponseEntity<Student>(studentService.save(student),HttpStatus.OK);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id){
        Student willDeleted = studentService.findById(id);
        studentService.deleteById(id);
        return new ResponseEntity<>(willDeleted,HttpStatus.OK);
    }

    @DeleteMapping("/students")
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student){
        return this.deleteStudentById(student.getId());
    }

    @GetMapping("/students/{gender}")
    public ResponseEntity<List<Student>> findStudentsByGender(@PathVariable char gender) {
        List<Student> students = studentService.findByGender(gender);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/student/{fullName}")
    public ResponseEntity<Student> deleteStudentByFullName(@PathVariable String fullName) {
        Student student = studentService.deleteByFullName(fullName);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }



}
