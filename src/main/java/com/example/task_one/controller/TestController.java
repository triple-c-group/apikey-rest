package com.example.task_one.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/healthcheck")
  public Map<String, String> healthcheck() {
    Map<String, String> map = new HashMap<>();
    map.put("status", "OK");
    return map;
  }

  @GetMapping("/protected")
  public Map<String, String> protectedRoute() {
    Map<String, String> map = new HashMap<>();
    map.put("status", "OK");
    return map;
  }
}
