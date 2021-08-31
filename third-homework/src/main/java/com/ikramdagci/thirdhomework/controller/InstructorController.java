package com.ikramdagci.thirdhomework.controller;

import com.ikramdagci.thirdhomework.model.Instructor;
import com.ikramdagci.thirdhomework.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable Long id) {
        return new ResponseEntity<Instructor>(instructorService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor addInsructor(Instructor instructor) {
        return instructorService.save(instructor);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<Instructor> deleteInstructorById(@PathVariable Long id){
        Instructor willDeleted = instructorService.findById(id);
        instructorService.deleteById(id);
        return new ResponseEntity<>(willDeleted,HttpStatus.OK);
    }

    @DeleteMapping("/instructors/{fullName}")
    public ResponseEntity<List<Instructor>> deleteInstructorById(@PathVariable String fullName){
        List<Instructor> instructorList = instructorService.deleteByName(fullName);
        return new ResponseEntity<>(instructorList,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findThreeHighestPaidInstructors() {
        List<Instructor> list =  instructorService.findThreeHighestPaidInstructors();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
