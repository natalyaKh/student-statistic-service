package com.statistic.articleservice.runner;

import com.statistic.articleservice.dto.ArticleDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArticleRunner implements CommandLineRunner {
    private static final Logger LOGGER =  LogManager.getLogger(ArticleRunner.class);
    public static Map<String, ArticleDto> articleMap = new HashMap<>();
    @Override
    public void run(String... args){
        LOGGER.info("created students " + LocalDateTime.now());
      ArticleDto art1 = ArticleDto.builder()
          .articleGrade(2430.0)
          .articleName("article1")
          .articleUuid("a11111")
          .studentUuid("11111")
          .build();
        ArticleDto art2 = ArticleDto.builder()
            .articleGrade(86.0)
            .articleName("article2")
            .articleUuid("a22222")
            .studentUuid("11111")
            .build();
        ArticleDto art3 = ArticleDto.builder()
            .articleGrade(540.0)
            .articleName("article3")
            .articleUuid("a33333")
            .studentUuid("22222")
            .build();
        ArticleDto art4 = ArticleDto.builder()
            .articleGrade(80.0)
            .articleName("article4")
            .articleUuid("a44444")
            .studentUuid("33333")
            .build();
        ArticleDto art5 = ArticleDto.builder()
            .articleGrade(50.5)
            .articleName("article5")
            .articleUuid("a55555")
            .studentUuid("22222")
            .build();
        ArticleDto art6 = ArticleDto.builder()
            .articleGrade(1024.0)
            .articleName("article6")
            .articleUuid("a66666")
            .studentUuid("66666")
            .build();
        ArticleDto art7 = ArticleDto.builder()
            .articleGrade(1044.0)
            .articleName("article7")
            .articleUuid("a77777")
            .studentUuid("88888")
            .build();
        ArticleDto art8 = ArticleDto.builder()
            .articleGrade(1034.0)
            .articleName("article8")
            .articleUuid("a88888")
            .studentUuid("88888")
            .build();
        ArticleDto art9 = ArticleDto.builder()
            .articleGrade(102.0)
            .articleName("article9")
            .articleUuid("a99999")
            .studentUuid("88888")
            .build();
        ArticleDto art10 = ArticleDto.builder()
            .articleGrade(102.0)
            .articleName("article10")
            .articleUuid("a10101")
            .studentUuid("10101")
            .build();
        articleMap.put(art1.getArticleUuid(), art1);
        articleMap.put(art2.getArticleUuid(), art2);
        articleMap.put(art3.getArticleUuid(), art3);
        articleMap.put(art4.getArticleUuid(), art4);
        articleMap.put(art5.getArticleUuid(), art5);
        articleMap.put(art6.getArticleUuid(), art6);
        articleMap.put(art7.getArticleUuid(), art7);
        articleMap.put(art8.getArticleUuid(), art8);
        articleMap.put(art9.getArticleUuid(), art9);
        articleMap.put(art10.getArticleUuid(), art10);



    }
}
