package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mary = new Student(
                "Mary",
                "mary@gmail.com",
                LocalDate.of(2000, APRIL, 23),
                21);
            Student elena = new Student(
                "Elena",
                "elena@gmail.com",
                LocalDate.of(2000, APRIL, 23),
                21);
            repository.saveAll(
                    List.of(mary, elena)
            );
        };
    }
}
