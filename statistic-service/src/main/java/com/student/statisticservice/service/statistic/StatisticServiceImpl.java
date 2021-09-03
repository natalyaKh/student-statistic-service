package com.student.statisticservice.service.statistic;

import com.student.statisticservice.controller.StatisticController;
import com.student.statisticservice.dto.StatisticDto;
import com.student.statisticservice.dto.webclientdto.ArticleDto;
import com.student.statisticservice.dto.webclientdto.StudentDto;
import com.student.statisticservice.enums.Constants;
import com.student.statisticservice.service.webclientservice.ArticleService;
import com.student.statisticservice.service.webclientservice.StudentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticController.class);
    @Autowired
    StudentsService studentsService;
    @Autowired
    ArticleService articleService;

    @Override
    public List<StatisticDto> getAllStatistic() {
        List<StudentDto> studentsList = studentsService.getAllStudents();
        List<ArticleDto> articlesList = articleService.getArticles();
        int studentSize = studentsList.size();
        int articleSize = articlesList.size();
        Map<String, StatisticDto> statMap = new HashMap<>();
        for (int i = 0; i < studentSize|| i < articleSize; i++) {
            statMap = checkStudents(studentsList, studentSize, statMap, i);
            statMap = checkArticles(articlesList, articleSize, statMap, i);
        }

        LOGGER.info(Constants.LIST_OF_ALL_STATISTIC + Constants.GOT);
        return new ArrayList<>(statMap.values());
    }

    private Map<String, StatisticDto> checkArticles(List<ArticleDto> articlesList, int articleSize, Map<String, StatisticDto> statMap, int i) {
        if (i < articleSize) {
            ArticleDto art = articlesList.get(i);
            StatisticDto statisticTmp = statMap.get(art.getStudentUuid());
            if (statisticTmp == null) {
                statisticTmp = setNewStatisticDtoArticle(art,statisticTmp);
            } else {
                statisticTmp = addToStatisticDtoArticle(art, statisticTmp);
            }
            statMap.put(art.getStudentUuid(), statisticTmp);
        }
        return statMap;
    }

    private StatisticDto addToStatisticDtoArticle(ArticleDto art, StatisticDto statisticTmp) {
        statisticTmp.setStudentName(statisticTmp.getStudentName());
        statisticTmp.setGrade(art.getArticleGrade());
        statisticTmp.setArticlesCount(art.getArticleCount());
        return statisticTmp;
    }

    private StatisticDto setNewStatisticDtoArticle(ArticleDto art, StatisticDto statisticTmp) {
        return StatisticDto.builder()
            .studentUuid(art.getStudentUuid())
            .grade(art.getArticleGrade())
            .articlesCount(art.getArticleCount())
            .build();
    }

    private Map<String, StatisticDto> checkStudents(List<StudentDto> studentsList, int studentSize, Map<String, StatisticDto> statMap, int i) {
        if (i < studentSize) {
            StudentDto st = studentsList.get(i);
            StatisticDto statisticTmp = statMap.get(st.getStudentUuid());
            if (statisticTmp == null) {
                statisticTmp = setNewStatisticDto(st, statisticTmp);
            } else {
                statisticTmp = addToStatisticDto(st, statisticTmp);
            }
            statMap.put(st.getStudentUuid(), statisticTmp);
        }
        return statMap;
    }

    private StatisticDto addToStatisticDto(StudentDto st, StatisticDto statisticTmp) {
        statisticTmp.setGrade(statisticTmp.getGrade());
        statisticTmp.setArticlesCount(statisticTmp.getArticlesCount());
        statisticTmp.setStudentName(st.getStudentName());
        return statisticTmp;
    }


    private StatisticDto setNewStatisticDto(StudentDto st, StatisticDto statisticTmp) {
        return StatisticDto.builder()
            .studentUuid(st.getStudentUuid())
            .studentName(st.getStudentName())
            .build();
    }

    @Override
    public List<StatisticDto> getBestStatistic() {
        LOGGER.info(Constants.LIST_OF_BEST_STUDENTS + Constants.GOT);
        List<StatisticDto> list = getAllStatistic();
        return
            list.stream()
                .filter(f -> f.getGrade() != null)
                .sorted((x1, x2) ->
                    (x2.getGrade().compareTo(x1.getGrade()))).limit(5).collect(Collectors.toList());
    }
}
