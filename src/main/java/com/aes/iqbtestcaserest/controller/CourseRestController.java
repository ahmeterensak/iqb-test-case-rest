package com.aes.iqbtestcaserest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aes.iqbtestcaserest.dto.CourseDTO;
import com.aes.iqbtestcaserest.mapper.CourseMapper;
import com.aes.iqbtestcaserest.model.Course;
import com.aes.iqbtestcaserest.service.ICourseService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@AllArgsConstructor
public class CourseRestController {

    ICourseService courseService;
    CourseMapper courseMapper;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courseDTOs = courseMapper.coursesToCourseDTOs(courseService.getAllCourses());
        return ResponseEntity.ok(courseDTOs);
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.courseDTOToCourse(courseDTO);
        boolean isSuccess = courseService.save(course);
        if (!isSuccess)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(courseDTO);
        return ResponseEntity.ok(courseDTO);
    }
}
