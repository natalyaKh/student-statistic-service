package com.student.statisticservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistic/ping")
public class PingController {

    @Value("${spring.application.name}")
    String applicationName;
    @GetMapping()
    public String ping(){

        return "I am work " + applicationName;
    }
}
