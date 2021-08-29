package com.example.studentservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Value("${spring.application.name}")
    String applicationName;
    @GetMapping()
    public String ping(){
        return "I am work " + applicationName;
    }
}
