package com.glorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Main {
    @GetMapping("/")
    public String greet(){
        return "Hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
