package com.myapplication.content.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@Validated
public class ContentQueryController {

    @GetMapping("/greetings")
    public String greetings() {
        return "Hey there! Welcome to my application";
    }

}
