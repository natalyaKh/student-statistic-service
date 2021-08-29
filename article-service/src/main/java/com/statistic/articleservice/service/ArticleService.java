package com.statistic.articleservice.service;

import com.statistic.articleservice.dto.AddGradeDto;
import com.statistic.articleservice.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();

    ArticleDto addGradeToArticle(AddGradeDto addGradeDto);
}
