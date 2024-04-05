package com.aes.iqbtestcaserest.service;

import java.util.List;

import com.aes.iqbtestcaserest.model.Student;

public interface IStudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student getStudentByNumber(int number);

    boolean save(Student student);
}
