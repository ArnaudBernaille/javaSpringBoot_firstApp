package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") // Comment est ce que cette class est appelée ? Est-ce que le fait de requeter sur le path fait que nous creons un objet de la class
public class StudentController {

    private final StudentService studentService;
    /*
    Privat final veut dire que de un on n'a pas accès à l'instance
    en dehors de la class mais en plus on ne peut pas modifier sa valeur une fois initialisé.
    */

    /*
    The @Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished.
    The @Autowired annotation can be used to autowire bean on the setter method just
    like @Required annotation, constructor, a property or methods with arbitrary names and/or multiple arguments.
     */
    @Autowired // sert à injecter la variable studentService dans le constructeur.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // On explique que c'est une requete Get, il existe aussi PostMapping sinon.
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // On peut aussi faire en sorte de verifier que le studentId du message n'est pas nul.
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}