package com.example.simpleServer;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
    public String name;
    public String surname;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Student(){
    }
}
