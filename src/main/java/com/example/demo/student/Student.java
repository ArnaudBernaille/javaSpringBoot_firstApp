package com.example.demo.student;

import javax.persistence.*; // Il faut faire en sorte de tououtoujours garder cet import
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate bod; // date of birth

    @Transient // le type de la video dit que c'est pour que l'age se calcul tout seul et ressorte dans le base de donnée
    // mais meme si je le retire ça marche encore donc je ne comprend plus rien.
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate bod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bod = bod;
    }
    public Student(String name,
                   String email,
                   LocalDate bod) {
        this.name = name;
        this.email = email;
        this.bod = bod;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBod() {
        return bod;
    }

    public Integer getAge() {
        return Period.between(bod, LocalDate.now()).getYears();
    }

    public void setName(String name){this.name = name;}


    public void setEmail(String email) { this.email = email;}
}
