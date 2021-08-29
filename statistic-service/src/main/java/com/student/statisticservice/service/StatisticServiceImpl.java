package com.student.statisticservice.service;

import com.student.statisticservice.dto.StatisticDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.student.statisticservice.runner.StatisticRunner.statisticMap;

@Service
public class StatisticServiceImpl implements StatisticService {



    @Override
    public List<StatisticDto> getAllStatistic() {
        return new ArrayList<>(statisticMap.values());
    }

    @Override
    public List<StatisticDto> getBestStatistic() {
    return  statisticMap.values().stream()
               .sorted((x1,x2)->
                   (x2.getGrade().compareTo(x1.getGrade()))).limit(5).collect(Collectors.toList());
    }
}
