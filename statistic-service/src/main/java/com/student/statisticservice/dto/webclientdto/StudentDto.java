package com.student.statisticservice.dto.webclientdto;

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
