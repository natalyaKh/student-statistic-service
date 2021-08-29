package com.student.statisticservice.service;

import com.student.statisticservice.controller.StatisticController;
import com.student.statisticservice.dto.StatisticDto;
import com.student.statisticservice.enums.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.student.statisticservice.runner.StatisticRunner.statisticMap;

@Service
public class StatisticServiceImpl implements StatisticService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticController.class);


    @Override
    public List<StatisticDto> getAllStatistic() {
        LOGGER.info(Constants.LIST_OF_ALL_STATISTIC + Constants.GOT);
        return new ArrayList<>(statisticMap.values());
    }

    @Override
    public List<StatisticDto> getBestStatistic() {
        LOGGER.info(Constants.LIST_OF_BEST_STUDENTS + Constants.GOT);
        return statisticMap.values().stream()
            .sorted((x1, x2) ->
                (x2.getGrade().compareTo(x1.getGrade()))).limit(5).collect(Collectors.toList());
    }
}
