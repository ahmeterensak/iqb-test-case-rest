package com.aes.iqbtestcaserest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aes.iqbtestcaserest.dto.CourseDTO;
import com.aes.iqbtestcaserest.mapper.CourseMapper;
import com.aes.iqbtestcaserest.model.Course;

@Component
public class CourseMapper {

    public CourseDTO courseToCourseDTO(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getName());

        return courseDTO;
    }

    public Course courseDTOToCourse(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course(courseDTO.getId(), courseDTO.getName());

        return course;
    }

    public List<CourseDTO> coursesToCourseDTOs(List<Course> courses) {
        if (courses == null) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>(courses.size());
        for (Course course : courses) {
            list.add(courseToCourseDTO(course));
        }

        return list;
    }

    public List<Course> courseDTOsToCourses(List<CourseDTO> courseDTOs) {
        if (courseDTOs == null) {
            return null;
        }

        List<Course> list = new ArrayList<Course>(courseDTOs.size());
        for (CourseDTO courseDTO : courseDTOs) {
            list.add(courseDTOToCourse(courseDTO));
        }

        return list;
    }
}
