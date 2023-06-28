package com.glorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
//    record Person(String name, int age, double savings){}
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//    ){}
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
//    @GetMapping("/greet")
//    public GreetResponse greet(){
//        return new GreetResponse(
//                "Hello",
//                List.of("Java", "JavaScript", "Python"),
//                new Person("Glorry", 20, 30_000)
//                );
//    }
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }
    public void addCustomer(NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
