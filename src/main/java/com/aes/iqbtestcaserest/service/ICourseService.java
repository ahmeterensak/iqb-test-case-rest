package com.aes.iqbtestcaserest.service;

import java.util.List;

import com.aes.iqbtestcaserest.model.Course;

public interface ICourseService {

    List<Course> getAllCourses();

    Course getCourseById(int id);

    boolean save(Course course);
    
}
