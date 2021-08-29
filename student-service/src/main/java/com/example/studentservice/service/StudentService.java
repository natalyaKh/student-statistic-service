package com.example.studentservice.service;

import com.example.studentservice.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudent(String studentUuid);
}
