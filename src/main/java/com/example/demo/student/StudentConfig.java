package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean // Le Bean semle etre un format de données mais je suis meme pas sur
    CommandLineRunner commandLineRUnner(StudentRepository repository){
            return args -> { // Docs le return args ?

                Student valeria = new Student(
                        "Valeria",
                        "vale@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5));
                Student jessica = new Student(
                        "Jessica",
                        "jessica@gmail.com",
                        LocalDate.of(2004, Month.JANUARY, 5));

                repository.saveAll(
                        List.of(valeria, jessica));
            };



        }
}

