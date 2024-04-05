package com.aes.iqbtestcaserest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aes.iqbtestcaserest.model.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {
    @Query("SELECT DISTINCT er FROM ExamResult er JOIN FETCH er.course WHERE er.student.id = :studentId")
    List<ExamResult> findAllResultsByStudentId(@Param("studentId") int studentId);

    @Query("SELECT DISTINCT er FROM ExamResult er JOIN FETCH er.student WHERE er.course.id = :courseId")
    List<ExamResult> findAllResultsByCourseId(@Param("courseId") int courseId);

    @Query("SELECT e.student.id, e.course.name, AVG(e.score) FROM ExamResult e WHERE (e.student.id, e.course.id) IN " +
            "(SELECT e2.student.id, e2.course.id FROM ExamResult e2 GROUP BY e2.student.id, e2.course.id " +
            "HAVING COUNT(e2) >= 3) GROUP BY e.student.id, e.course.name")
    Object[] getAllAveragesOfCompletedCoursesForStudents();

    @Query("Select COUNT(*) FROM ExamResult e WHERE e.student.id = :studentId AND e.course.id = :courseId")
    int findExamResultCount(@Param("studentId") int studentId, @Param("courseId") int courseId);

}
