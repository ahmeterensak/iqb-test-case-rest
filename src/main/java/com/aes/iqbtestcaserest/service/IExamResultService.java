package com.aes.iqbtestcaserest.service;

import java.util.List;

import com.aes.iqbtestcaserest.model.ExamResult;

public interface IExamResultService {
    List<ExamResult> getResultsByStudentId(int studentId);

    List<ExamResult> getResultsByCourseId(int courseId);

    boolean save(ExamResult examResult);

    Object[] getAllAveragesOfCompletedCoursesForStudents();

    int getExamResultCount(int studentId, int courseId);
}
