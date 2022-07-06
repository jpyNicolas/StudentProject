package com.example.demo.modules.service;

import com.example.demo.modules.entities.Student;
import com.example.demo.modules.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public Student registerStudent(Student student){
        return repository.save(student);
    }

    public void updateStudent(Long id, Student tmpStudent){
    //        Student student = repository.getReferenceById(id);
    //        student.setName(tmpStudent.getName());
    //        student.setLastName(tmpStudent.getLastName());
    //        student.setNationalCode(tmpStudent.getNationalCode());
    //        student.setAge(tmpStudent.getAge());
    //        student.setDateOfBirth(tmpStudent.getDateOfBirth());
    //        return repository.s;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setName(tmpStudent.getName());
        student.setLastName(tmpStudent.getLastName());
        student.setNationalCode(tmpStudent.getNationalCode());
        student.setAge(tmpStudent.getAge());
        student.setDateOfBirth(tmpStudent.getDateOfBirth());
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(Long id){
        repository.deleteById(id);
    }

    public Optional<Student> getStudent(Long id){
        return repository.findById(id);
    }
}
