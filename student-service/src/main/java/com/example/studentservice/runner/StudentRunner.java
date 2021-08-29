package com.example.studentservice.runner;

import com.example.studentservice.dto.StudentDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRunner implements CommandLineRunner {
    private static final Logger LOGGER =  LogManager.getLogger(StudentRunner.class);
    public static Map<String, StudentDto> studentMap = new HashMap<>();
    @Override
    public void run(String... args){
        LOGGER.info("created students " + LocalDateTime.now());
        StudentDto stDto1 = StudentDto.builder()
            .studentName("student1")
            .studentUuid("11111")
            .build();
        StudentDto stDto2 = StudentDto.builder()
            .studentName("student2")
            .studentUuid("22222")
            .build();
        StudentDto stDto3 = StudentDto.builder()
            .studentName("student3")
            .studentUuid("33333")
            .build();
        StudentDto stDto4 = StudentDto.builder()
            .studentName("student4")
            .studentUuid("4444")
            .build();
        StudentDto stDto5 = StudentDto.builder()
            .studentName("student5")
            .studentUuid("55555")
            .build();
        StudentDto stDto6 = StudentDto.builder()
            .studentName("student6")
            .studentUuid("66666")
            .build();
        StudentDto stDto7 = StudentDto.builder()
            .studentName("student7")
            .studentUuid("77777")
            .build();
        StudentDto stDto8 = StudentDto.builder()
            .studentName("studen81")
            .studentUuid("88888")
            .build();
        StudentDto stDto9 = StudentDto.builder()
            .studentName("student9")
            .studentUuid("99999")
            .build();
        StudentDto stDto10 = StudentDto.builder()
            .studentName("student10")
            .studentUuid("10101")
            .build();
        studentMap.put(stDto1.getStudentUuid(), stDto1);
        studentMap.put(stDto2.getStudentUuid(), stDto2);
        studentMap.put(stDto3.getStudentUuid(), stDto3);
        studentMap.put(stDto4.getStudentUuid(), stDto4);
        studentMap.put(stDto5.getStudentUuid(), stDto5);
        studentMap.put(stDto6.getStudentUuid(), stDto6);
        studentMap.put(stDto7.getStudentUuid(), stDto7);
        studentMap.put(stDto8.getStudentUuid(), stDto8);
        studentMap.put(stDto9.getStudentUuid(), stDto9);
        studentMap.put(stDto10.getStudentUuid(), stDto10);
    }
}
