package com.group.libraryapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello1223241";
    }
    @GetMapping("/star")
    public String star(){
        return "*********************2";
    }
}
