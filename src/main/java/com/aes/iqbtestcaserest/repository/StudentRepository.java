package com.aes.iqbtestcaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aes.iqbtestcaserest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByNumber(int number);

    Student findByEmail(String email);

    Student findByGsmNumber(String gsmNumber);

}
