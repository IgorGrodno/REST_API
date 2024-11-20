package com.example.rest_api;

import com.example.rest_api.entities.User;
import com.example.rest_api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {

        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {

                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            for (User user : userRepository.findAll()) {
                System.out.println(user.getId());
            }
        };
    }
}



