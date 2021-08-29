package com.statistic.articleservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddGradeDto {
    @NotNull
    String articleUuid;
    @NotNull
    Double articleGrade;
}
