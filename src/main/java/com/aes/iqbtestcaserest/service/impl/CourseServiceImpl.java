package com.aes.iqbtestcaserest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aes.iqbtestcaserest.model.Course;
import com.aes.iqbtestcaserest.repository.CourseRepository;
import com.aes.iqbtestcaserest.service.ICourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Course course) {
        if (courseRepository.findByName(course.getName()) != null) {
            return false;
        }
        courseRepository.save(course);
        return true;
    }
}
