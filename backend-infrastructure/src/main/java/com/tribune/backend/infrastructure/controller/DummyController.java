package com.tribune.backend.infrastructure.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/v1/dummy")
@RestController
public class DummyController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
