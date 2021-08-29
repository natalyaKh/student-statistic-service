package com.student.statisticservice.runner;

import com.student.statisticservice.dto.StatisticDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class StatisticRunner implements CommandLineRunner {
    private static final Logger LOGGER =  LogManager.getLogger(StatisticRunner.class);
    public static Map<String, StatisticDto> statisticMap = new HashMap<>();
    @Override
    public void run(String... args){
        LOGGER.info("created statistic " + LocalDateTime.now());
        StatisticDto stDto1 = StatisticDto.builder()
            .articlesCount(5)
            .grade(80.7)
            .studentName("student1")
            .studentUuid("11111")
            .build();
        StatisticDto stDto2 = StatisticDto.builder()
            .articlesCount(1)
            .grade(10.0)
            .studentName("student2")
            .studentUuid("22222")
            .build();
        StatisticDto stDto3 = StatisticDto.builder()
            .articlesCount(20)
            .grade(99.5)
            .studentName("student3")
            .studentUuid("33333")
            .build();
        StatisticDto stDto4 = StatisticDto.builder()
            .articlesCount(3)
            .grade(60.7)
            .studentName("student4")
            .studentUuid("4444")
            .build();
        StatisticDto stDto5 = StatisticDto.builder()
            .articlesCount(2)
            .grade(75.7)
            .studentName("student5")
            .studentUuid("55555")
            .build();
        StatisticDto stDto6 = StatisticDto.builder()
            .articlesCount(6)
            .grade(33.3)
            .studentName("student6")
            .studentUuid("66666")
            .build();
        StatisticDto stDto7 = StatisticDto.builder()
            .articlesCount(8)
            .grade(90.7)
            .studentName("student7")
            .studentUuid("77777")
            .build();
        StatisticDto stDto8 = StatisticDto.builder()
            .articlesCount(2)
            .grade(50.0)
            .studentName("studen81")
            .studentUuid("88888")
            .build();
        StatisticDto stDto9 = StatisticDto.builder()
            .articlesCount(4)
            .grade(20.8)
            .studentName("student9")
            .studentUuid("99999")
            .build();
        StatisticDto stDto10 = StatisticDto.builder()
            .articlesCount(10)
            .grade(100.0)
            .studentName("student10")
            .studentUuid("10101")
            .build();
        statisticMap.put(stDto1.getStudentUuid(), stDto1);
        statisticMap.put(stDto2.getStudentUuid(), stDto2);
        statisticMap.put(stDto3.getStudentUuid(), stDto3);
        statisticMap.put(stDto4.getStudentUuid(), stDto4);
        statisticMap.put(stDto5.getStudentUuid(), stDto5);
        statisticMap.put(stDto6.getStudentUuid(), stDto6);
        statisticMap.put(stDto7.getStudentUuid(), stDto7);
        statisticMap.put(stDto8.getStudentUuid(), stDto8);
        statisticMap.put(stDto9.getStudentUuid(), stDto9);
        statisticMap.put(stDto10.getStudentUuid(), stDto10);
    }
}
