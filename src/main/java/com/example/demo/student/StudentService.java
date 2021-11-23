package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*
Service Components are the class file which contains @Service annotation.
These class files are used to write business logic in a different layer,
separated from @RestController class file.
The logic for creating a service component class file is shown here −
 */

@Service // Pour expliquer que cette class est une "bean", va être injectée. // Le @Service fait la meme chose que @comonent mais c'et pour pouvoir lire mieux on peut dire que c'est un service.
public class StudentService {

    public List<Student> getStudents(){

        return List.of(
                new Student(1L,
                        "Valeria",
                        "vale@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21)
        );
    }
}
