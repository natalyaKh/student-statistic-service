package com.example.studentservice.service;

import com.example.studentservice.dto.StudentDto;
import com.example.studentservice.enums.Constants;
import com.example.studentservice.exceptions.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.studentservice.runner.StudentRunner.studentMap;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public List<StudentDto> getAllStudents() {
        LOGGER.info(Constants.LIST_OF_ALL_STUDENTS + Constants.GOT);
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public StudentDto getStudent(String studentUuid) {
        StudentDto student = studentMap.get(studentUuid);
        if(student == null) throw new StudentNotFoundException(Constants.STUDENT + studentUuid + Constants.NOT_FOUND);
        LOGGER.info(Constants.STUDENT + studentUuid + Constants.GOT);
        return student;
    }
}
