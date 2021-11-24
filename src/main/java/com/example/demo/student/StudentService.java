package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*
Service Components are the class file which contains @Service annotation.
These class files are used to write business logic in a different layer,
separated from @RestController class file.
The logic for creating a service component class file is shown here −
 */

@Service // Pour expliquer que cette class est une "bean", va être injectée. // Le @Service fait la meme chose que @comonent mais c'et pour pouvoir lire mieux on peut dire que c'est un service.
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id " + studentId + " does not exists");
            // sera renvoyé au serveur en cas d'erreur.
        }
        else {
            studentRepository.deleteById(studentId);
        }

    }

    @Transactional // On n'a pas a implementer un jpa qwery grâce à ce mot clef. // Cf le cours sur les jpa data du amigocode
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exists")
                );
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            // On verifie que le mail n'a pas été prit :
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken, you can't modify it this way");
            }
            student.setEmail(email);
        }
    }
}
