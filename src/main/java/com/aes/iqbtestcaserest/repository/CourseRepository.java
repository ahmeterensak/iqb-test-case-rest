package com.aes.iqbtestcaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aes.iqbtestcaserest.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Object findByName(String name);

}
