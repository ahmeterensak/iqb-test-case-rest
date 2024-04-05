package com.aes.iqbtestcaserest.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResult {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private int score;

        @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH }, targetEntity = Student.class)
        @JoinColumn(name = "student_id", referencedColumnName = "id")
        private Student student;

        @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH }, targetEntity = Course.class)
        @JoinColumn(name = "course_id", referencedColumnName = "id")
        private Course course;
}
