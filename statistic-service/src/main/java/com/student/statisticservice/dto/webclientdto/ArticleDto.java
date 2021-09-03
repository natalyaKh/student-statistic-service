package com.student.statisticservice.dto.webclientdto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArticleDto {
    String studentUuid;
    Double articleGrade;
    Long articleCount;
}
