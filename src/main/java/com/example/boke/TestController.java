package com.example.boke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/hello")
    public List<String> hello(){
        return List.of("hello","恭喜你创建了第一个页面");
    }
}
