package com.aes.iqbtestcaserest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aes.iqbtestcaserest.dto.StudentDTO;
import com.aes.iqbtestcaserest.mapper.StudentMapper;
import com.aes.iqbtestcaserest.model.Student;
import com.aes.iqbtestcaserest.service.IStudentService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
@AllArgsConstructor
public class StudentRestController {

    IStudentService studentService;
    StudentMapper studentMapper;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOs = studentMapper.studentsToStudentDTOs(students);
        return ResponseEntity.ok(studentDTOs);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable(value = "id") int id) {
        StudentDTO studentDTO = studentMapper.studentToStudentDTO(studentService.getStudentById(id));
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        boolean isSuccess = studentService.save(student);
        if (!isSuccess)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentDTO);
        return ResponseEntity.ok(studentDTO);
    }

}
