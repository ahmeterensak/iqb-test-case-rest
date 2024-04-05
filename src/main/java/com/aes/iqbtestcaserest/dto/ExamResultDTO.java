package com.aes.iqbtestcaserest.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResultDTO {
    private int id;
    private int score;
    private StudentDTO student;
    private CourseDTO course;
}
