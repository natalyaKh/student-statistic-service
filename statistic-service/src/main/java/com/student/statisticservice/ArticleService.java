package com.student.statisticservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
//    private WebClient webClient;
    WebClient webClient;


    public List<ArticleDto> getArticles() {
//        WebClient.builder().baseUrl("http://article-service/article/all");
        Mono<ArticleDto[]> response = webClient.get()
            .uri("http://article-service/article/all")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ArticleDto[].class).log();

        ArticleDto[] objects = response.block();
        return Arrays.asList(objects);
    }
}
