package com.glorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    record GreetResponse(String greet){}
//    class GreetResponse{
//        private final String greet;
//        GreetResponse(String greet){
//            this.greet=greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
