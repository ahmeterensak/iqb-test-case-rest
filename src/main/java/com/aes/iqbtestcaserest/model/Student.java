package com.aes.iqbtestcaserest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private int number;

    private String email;

    private String gsmNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExamResult> examResultsList;

    public Student(int id, String fullName, int number, String email, String gsmNumber) {
        this.id = id;
        this.fullName = fullName;
        this.number = number;
        this.email = email;
        this.gsmNumber = gsmNumber;
    }

}
