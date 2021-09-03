package com.student.statisticservice.service.webclientservice;

import com.student.statisticservice.dto.webclientdto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private WebClient webClient;

    public List<StudentDto> getAllStudents() {
        Mono<StudentDto[]> response = webClient.get()
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(StudentDto[].class).log();
        StudentDto[] objects = response.block();
        return Arrays.asList(objects);
    }
}
