package com.statistic.articleservice.controllers;

import com.statistic.articleservice.dto.AddGradeDto;
import com.statistic.articleservice.dto.ArticleDto;
import com.statistic.articleservice.enums.Constants;
import com.statistic.articleservice.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        List<ArticleDto> articlesDtoList = articleService.getAllArticles();
        LOGGER.info(Constants.LIST_OF_ALL_ARTICLES + Constants.RETURNED);
        return new ResponseEntity<>(articlesDtoList, HttpStatus.OK);
    }

    @PutMapping("/grade")
    public ResponseEntity<ArticleDto> addGradeToArticle(@Valid @RequestBody AddGradeDto addGradeDto) {
        ArticleDto articleWithGrade = articleService.addGradeToArticle(addGradeDto);
        LOGGER.info(Constants.GRADE + addGradeDto.getArticleGrade() + Constants.TO_ARTICLE
            + addGradeDto.getArticleUuid() + Constants.ADDED);
        return new ResponseEntity<>(articleWithGrade, HttpStatus.OK);
    }


}
