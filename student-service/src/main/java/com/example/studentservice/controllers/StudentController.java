package com.example.studentservice.controllers;

import com.example.studentservice.dto.StudentDto;
import com.example.studentservice.enums.Constants;
import com.example.studentservice.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentsDtoList = studentService.getAllStudents();
        LOGGER.info(Constants.LIST_OF_ALL_STUDENTS + Constants.RETURNED);
        return new ResponseEntity<>(studentsDtoList, HttpStatus.OK);
    }

    @GetMapping("/{studentUuid}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable String studentUuid) {
        StudentDto student = studentService.getStudent(studentUuid);
        LOGGER.info(Constants.STUDENT  + studentUuid + Constants.RETURNED);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
