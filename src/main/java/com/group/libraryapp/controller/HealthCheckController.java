package com.group.libraryapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${server.env}")
    private String env;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.serverAddress}")
    private String serverAddress;

    @Value("${server.serverName}")
    private String serverName;

    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck(){
        Map<String,String> responseData = new HashMap<>();
        responseData.put("serverName",serverName);
        responseData.put("serverAddress",serverAddress);
        responseData.put("serverPort",serverPort);
        responseData.put("env",env);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv(){
        // 정보를 넣어서 줄거임 얘가 그린인지 블루인지
        // 어떤 서버가 켜져 있는지
        return ResponseEntity.ok(env);
    }

    @GetMapping("/envv")
    public ResponseEntity<?> getEnvv(){
        System.out.println("test test test test test");
        return ResponseEntity.ok(env);
    }
}
