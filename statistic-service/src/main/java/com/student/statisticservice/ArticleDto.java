package com.student.statisticservice;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArticleDto {
    String articleUuid;
    String articleName;
    String studentUuid;
    Double articleGrade;

}
