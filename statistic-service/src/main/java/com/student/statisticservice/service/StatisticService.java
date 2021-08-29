package com.student.statisticservice.service;

import com.student.statisticservice.dto.StatisticDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticService {
    List<StatisticDto> getAllStatistic();

    List<StatisticDto> getBestStatistic();
}
