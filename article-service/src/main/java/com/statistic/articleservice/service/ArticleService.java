package com.statistic.articleservice.service;

import com.statistic.articleservice.dto.AddGradeDto;
import com.statistic.articleservice.dto.ArticleDto;
import com.statistic.articleservice.dto.ArticleResponseDto;

import java.util.List;

public interface ArticleService {
    List<ArticleResponseDto> getAllArticles();

    ArticleDto addGradeToArticle(AddGradeDto addGradeDto);
}
