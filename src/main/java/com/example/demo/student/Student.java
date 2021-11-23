package com.example.demo.student;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String name;
    private String email;
    private LocalDate bod; // date of birth
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate bod,
                   Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bod = bod;
        this.age = age;
    }
    public Student(String name,
                   String email,
                   LocalDate bod,
                   Integer age) {
        this.name = name;
        this.email = email;
        this.bod = bod;
        this.age = age;
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
        return age;
    }

    /*
    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bod=" + bod +
                ", age=" + age +
                '}';
    }
    */

}
