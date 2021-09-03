package com.statistic.articleservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArticleResponseDto {
    String studentUuid;
    Double articleGrade;
    Long articleCount;

}
