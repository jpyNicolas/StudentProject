package com.example.demo.modules.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code")
    private String nationalCode;

    private Integer age;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public Student() {
    }

    public Student(String name, String lastName, String nationalCode, Integer age, Timestamp dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
}
