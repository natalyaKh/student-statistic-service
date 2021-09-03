package com.statistic.articleservice.service;

import com.statistic.articleservice.dto.AddGradeDto;
import com.statistic.articleservice.dto.ArticleDto;
import com.statistic.articleservice.dto.ArticleResponseDto;
import com.statistic.articleservice.enums.Constants;
import com.statistic.articleservice.exceptions.ArticleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.statistic.articleservice.runner.ArticleRunner.articleMap;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public List<ArticleResponseDto> getAllArticles() {
        List<ArticleResponseDto> rez = new ArrayList<>();
        Map<String, Double> articlesByStudentAndAverageGrade = articleMap.values().stream()
            .collect(Collectors.groupingBy(ArticleDto::getStudentUuid,
                Collectors.averagingDouble(ArticleDto::getArticleGrade)));
        Map<String, Long> count = articleMap.values().stream()
            .collect(Collectors.groupingBy(ArticleDto::getStudentUuid, Collectors.counting()));

        for ( String studentUuid : articlesByStudentAndAverageGrade.keySet()) {
            rez.add(ArticleResponseDto.builder()
                .articleGrade(articlesByStudentAndAverageGrade.get(studentUuid))
                .studentUuid(studentUuid)
                .articleCount(count.get(studentUuid))
                .build());
        }
        LOGGER.info(Constants.LIST_OF_ALL_ARTICLES + Constants.GOT);
        return rez;
    }

    @Override
    public ArticleDto addGradeToArticle(AddGradeDto addGradeDto) {
        ArticleDto articleDto = articleMap.get(addGradeDto.getArticleUuid());
        if (articleDto == null) throw new ArticleNotFoundException(
            Constants.ARTICLE + addGradeDto.getArticleUuid() + Constants.NOT_FOUND
        );
        articleDto.setArticleGrade(addGradeDto.getArticleGrade());
        articleMap.put(articleDto.getArticleUuid(), articleDto);
        LOGGER.info(Constants.GRADE + addGradeDto.getArticleGrade()
            + Constants.ADDED + Constants.TO_ARTICLE + addGradeDto.getArticleUuid());
        return articleDto;
    }
}
