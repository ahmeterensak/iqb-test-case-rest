package com.aes.iqbtestcaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aes.iqbtestcaserest.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Object findByName(String name);
}
