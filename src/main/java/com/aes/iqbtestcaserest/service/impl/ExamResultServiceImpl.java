package com.aes.iqbtestcaserest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aes.iqbtestcaserest.model.Course;
import com.aes.iqbtestcaserest.model.ExamResult;
import com.aes.iqbtestcaserest.model.Student;
import com.aes.iqbtestcaserest.repository.ExamResultRepository;
import com.aes.iqbtestcaserest.service.ICourseService;
import com.aes.iqbtestcaserest.service.IExamResultService;
import com.aes.iqbtestcaserest.service.IStudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExamResultServiceImpl implements IExamResultService {

    ExamResultRepository examResultRepository;
    IStudentService studentService;
    ICourseService courseService;

    @Override
    public List<ExamResult> getResultsByStudentId(int studentId) {
        return examResultRepository.findAllResultsByStudentId(studentId);
    }

    @Override
    public List<ExamResult> getResultsByCourseId(int courseId) {
        return examResultRepository.findAllResultsByCourseId(courseId);

    }

    @Override
    public boolean save(ExamResult examResult) {

        int examResultCount = getExamResultCount(examResult.getStudent().getId(), examResult.getCourse().getId());
        if (examResultCount >= 3) {
            return false;
        }

        Student student = studentService.getStudentById(examResult.getStudent().getId());
        examResult.setStudent(student);

        Course course = courseService.getCourseById(examResult.getCourse().getId());
        examResult.setCourse(course);

        examResultRepository.save(examResult);
        return true;
    }

    @Override
    public Object[] getAllAveragesOfCompletedCoursesForStudents() {
        return examResultRepository.getAllAveragesOfCompletedCoursesForStudents();
    }

    @Override
    public int getExamResultCount(int studentId, int courseId) {
        return examResultRepository.findExamResultCount(studentId, courseId);
    }

}
