package com.student.statisticservice.controller;

import com.student.statisticservice.StudenService;
import com.student.statisticservice.StudentDto;
import com.student.statisticservice.dto.StatisticDto;
import com.student.statisticservice.enums.Constants;
import com.student.statisticservice.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticController.class);


    @Autowired
    StatisticService statisticService;
    @Autowired
    StudenService studenService;


    @GetMapping("/test")
    public List<StudentDto> getStudents(){
        List<StudentDto> s = studenService.price();
        return s;
    }


    @GetMapping("/all")
    public ResponseEntity<List<StatisticDto>> getAllStatistic(){
        List<StatisticDto> statisticsDtoList = statisticService.getAllStatistic();
        LOGGER.info(Constants.LIST_OF_ALL_STATISTIC + Constants.RETURNED);
        return new ResponseEntity<>(statisticsDtoList, HttpStatus.OK);
    }

    @GetMapping("/best")
    public ResponseEntity<List<StatisticDto>> getBestStatistic(){
        List<StatisticDto> bestStatisticsList = statisticService.getBestStatistic();
        LOGGER.info(Constants.LIST_OF_BEST_STUDENTS + Constants.RETURNED);
        return new ResponseEntity<>(bestStatisticsList, HttpStatus.OK);
    }
}
