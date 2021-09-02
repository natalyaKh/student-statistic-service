package com.student.statisticservice;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDto {
    String studentUuid;
    String studentName;
}
