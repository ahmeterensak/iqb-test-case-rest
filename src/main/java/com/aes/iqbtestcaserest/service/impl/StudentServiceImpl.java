package com.aes.iqbtestcaserest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aes.iqbtestcaserest.model.Student;
import com.aes.iqbtestcaserest.repository.StudentRepository;
import com.aes.iqbtestcaserest.service.IStudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    public Student getStudentByNumber(int number) {
        return studentRepository.findByNumber(number);
    }

    @Override
    public boolean save(Student student) {
        if (studentRepository.findByNumber(student.getNumber()) != null
                || studentRepository.findByEmail(student.getEmail()) != null
                || studentRepository.findByGsmNumber(student.getGsmNumber()) != null) {
            return false;
        }
        studentRepository.save(student);
        return true;
    }
}
