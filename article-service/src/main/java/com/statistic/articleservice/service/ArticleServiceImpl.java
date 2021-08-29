package com.statistic.articleservice.service;

import com.statistic.articleservice.dto.AddGradeDto;
import com.statistic.articleservice.dto.ArticleDto;
import com.statistic.articleservice.enums.Constants;
import com.statistic.articleservice.exceptions.ArticleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.statistic.articleservice.runner.ArticleRunner.articleMap;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public List<ArticleDto> getAllArticles() {
        LOGGER.info(Constants.LIST_OF_ALL_ARTICLES + Constants.GOT);
        return new ArrayList<>(articleMap.values());
    }

    @Override
    public ArticleDto addGradeToArticle(AddGradeDto addGradeDto) {
        ArticleDto articleDto = articleMap.get(addGradeDto.getArticleUuid());
        if(articleDto == null) throw new ArticleNotFoundException(
            Constants.ARTICLE + addGradeDto.getArticleUuid() + Constants.NOT_FOUND
        );
        articleDto.setArticleGrade(addGradeDto.getArticleGrade());
        articleMap.put(articleDto.getArticleUuid(), articleDto);
        LOGGER.info(Constants.GRADE + addGradeDto.getArticleGrade()
        + Constants.ADDED + Constants.TO_ARTICLE + addGradeDto.getArticleUuid());
        return articleDto;
    }
}
