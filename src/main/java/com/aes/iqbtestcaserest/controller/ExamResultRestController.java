package com.aes.iqbtestcaserest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aes.iqbtestcaserest.dto.ExamResultDTO;
import com.aes.iqbtestcaserest.mapper.ExamResultMapper;
import com.aes.iqbtestcaserest.model.ExamResult;
import com.aes.iqbtestcaserest.service.ICourseService;
import com.aes.iqbtestcaserest.service.IExamResultService;
import com.aes.iqbtestcaserest.service.IStudentService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("/api")
public class ExamResultRestController {
    IExamResultService examResultService;
    IStudentService studentService;
    ICourseService courseService;
    ExamResultMapper examResultMapper;

    @GetMapping("/results/students/{studentId}")
    public ResponseEntity<List<ExamResultDTO>> getCoursesByStudentId(@PathVariable int studentId) {
        List<ExamResult> examResults = examResultService.getResultsByStudentId(studentId);
        List<ExamResultDTO> results = examResultMapper
                .examResultsToExamResultDTOs(examResults);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/results/courses/{courseId}")
    public ResponseEntity<List<ExamResultDTO>> getStudentsByCourseId(@PathVariable int courseId) {
        List<ExamResult> examResults = examResultService.getResultsByCourseId(courseId);
        List<ExamResultDTO> results = examResultMapper
                .examResultsToExamResultDTOs(examResults);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/results/getAllAveragesOfCompletedCoursesForStudents")
    public ResponseEntity<Object[]> getAllAveragesOfCompletedCoursesForStudents() {
        Object[] averages = examResultService.getAllAveragesOfCompletedCoursesForStudents();
        return ResponseEntity.ok(averages);
    }

    @PostMapping("/results")
    public ResponseEntity<ExamResultDTO> addExamResult(@RequestBody ExamResultDTO examResultDTO) {

        ExamResult examResult = examResultMapper.examResultDTOToexamResult(examResultDTO);
        boolean isSuccess = examResultService.save(examResult);
        if (!isSuccess)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(examResultDTO);
        return new ResponseEntity<>(examResultDTO, HttpStatus.CREATED);
    }

}
