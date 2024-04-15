package com.group.libraryapp.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testtest")
    public String hello(){
        return "testtest";
    }
}
