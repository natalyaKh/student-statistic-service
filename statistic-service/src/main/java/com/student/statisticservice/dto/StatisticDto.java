package com.student.statisticservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StatisticDto {
    String studentUuid;
    String studentName;
    Double grade;
    Long articlesCount;
}
