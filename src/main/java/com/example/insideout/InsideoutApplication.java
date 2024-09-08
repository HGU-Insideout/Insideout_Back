package com.example.insideout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class InsideoutApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsideoutApplication.class, args);
    }

}
