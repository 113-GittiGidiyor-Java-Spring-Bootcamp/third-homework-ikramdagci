package com.ikramdagci.thirdhomework.service;

import com.ikramdagci.thirdhomework.exception.StaffNotFoundException;
import com.ikramdagci.thirdhomework.model.Course;
import com.ikramdagci.thirdhomework.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new StaffNotFoundException(id));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }
}
