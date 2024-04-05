package com.aes.iqbtestcaserest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aes.iqbtestcaserest.dto.StudentDTO;
import com.aes.iqbtestcaserest.mapper.StudentMapper;
import com.aes.iqbtestcaserest.model.Student;

@Component
public class StudentMapper {

    public StudentDTO studentToStudentDTO(Student student) {
        if (student == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO(student.getId(), student.getFullName(), student.getNumber(),
                student.getEmail(), student.getGsmNumber());

        return studentDTO;
    }

    public Student studentDTOToStudent(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student student = new Student(studentDTO.getId(), studentDTO.getFullName(), studentDTO.getNumber(),
                studentDTO.getEmail(), studentDTO.getGsmNumber());

        return student;
    }

    public List<StudentDTO> studentsToStudentDTOs(List<Student> students) {
        if (students == null) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>(students.size());
        for (Student student : students) {
            list.add(studentToStudentDTO(student));
        }

        return list;
    }

    public List<Student> studentDTOsToStudents(List<StudentDTO> studentDTOs) {
        if (studentDTOs == null) {
            return null;
        }

        List<Student> list = new ArrayList<Student>(studentDTOs.size());
        for (StudentDTO studentDTO : studentDTOs) {
            list.add(studentDTOToStudent(studentDTO));
        }

        return list;
    }
}
