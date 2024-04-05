package com.aes.iqbtestcaserest.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String fullName;
    private int number;
    private String email;
    private String gsmNumber;
}
