package com.aes.iqbtestcaserest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aes.iqbtestcaserest.dto.ExamResultDTO;
import com.aes.iqbtestcaserest.mapper.ExamResultMapper;
import com.aes.iqbtestcaserest.model.ExamResult;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ExamResultMapper {

    StudentMapper studentMapper;
    CourseMapper courseMapper;

    public ExamResultDTO examResultToexamResultDTO(ExamResult examResult) {
        if (examResult == null) {
            return null;
        }

        ExamResultDTO examResultDTO = new ExamResultDTO(examResult.getId(), examResult.getScore(),
                studentMapper.studentToStudentDTO(examResult.getStudent()),
                courseMapper.courseToCourseDTO(examResult.getCourse()));

        return examResultDTO;
    }

    public ExamResult examResultDTOToexamResult(ExamResultDTO examResultDTO) {
        if (examResultDTO == null) {
            return null;
        }

        ExamResult examResult = new ExamResult(examResultDTO.getId(), examResultDTO.getScore(),
                studentMapper.studentDTOToStudent(examResultDTO.getStudent()),
                courseMapper.courseDTOToCourse(examResultDTO.getCourse()));

        return examResult;
    }

    public List<ExamResultDTO> examResultsToExamResultDTOs(List<ExamResult> examResults) {
        if (examResults == null) {
            return null;
        }

        List<ExamResultDTO> list = new ArrayList<ExamResultDTO>(examResults.size());
        for (ExamResult examResult : examResults) {
            list.add(examResultToexamResultDTO(examResult));
        }

        return list;
    }

    public List<ExamResult> examResultDTOsToExamResults(List<ExamResultDTO> examResultDTOs) {
        if (examResultDTOs == null) {
            return null;
        }

        List<ExamResult> list = new ArrayList<ExamResult>(examResultDTOs.size());
        for (ExamResultDTO examResultDTO : examResultDTOs) {
            list.add(examResultDTOToexamResult(examResultDTO));
        }

        return list;
    }
}
