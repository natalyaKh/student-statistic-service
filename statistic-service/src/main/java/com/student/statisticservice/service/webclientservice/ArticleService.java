package com.student.statisticservice.service.webclientservice;

import com.student.statisticservice.dto.webclientdto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    WebClient webClient;
    @Value("${articleUrl}")
    String articleUrl;

    public List<ArticleDto> getArticles() {
        Mono<ArticleDto[]> response = webClient.get()
            .uri(articleUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ArticleDto[].class).log();

        ArticleDto[] rez = response.block();
        if (rez.length == 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(rez);
    }
}
