package com.student.statisticservice.controller;

import com.student.statisticservice.dto.StatisticDto;
import com.student.statisticservice.service.StatisticService;
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


    @Autowired
    StatisticService statisticService;

    @GetMapping("/all")
    public ResponseEntity<List<StatisticDto>> getAllStatistic(){
        List<StatisticDto> statisticsDtoList = statisticService.getAllStatistic();
        return new ResponseEntity<>(statisticsDtoList, HttpStatus.OK);
    }

    @GetMapping("/best")
    public ResponseEntity<List<StatisticDto>> getBestStatistic(){
        List<StatisticDto> bestStatisticsList = statisticService.getBestStatistic();
        return new ResponseEntity<>(bestStatisticsList, HttpStatus.OK);
    }
}
