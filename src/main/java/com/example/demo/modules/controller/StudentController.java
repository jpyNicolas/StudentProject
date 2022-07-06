package com.example.demo.modules.controller;

import com.example.demo.modules.entities.Student;
import com.example.demo.modules.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class StudentController {
    StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student){
        return service.registerStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }
}
