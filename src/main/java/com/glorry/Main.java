package com.glorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    record Person(String name){}
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){}
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
        return new GreetResponse(
                "Hello",
                List.of("Java", "JavaScript", "Python"),
                new Person("Glorry")
                );
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
