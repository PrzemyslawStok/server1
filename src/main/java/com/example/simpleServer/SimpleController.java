package com.example.simpleServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SimpleController {
    List<Integer> array = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    static ArrayList<Student> students  = new ArrayList<>();
    static{
        for(int i=0;i<10;i++)
            students.add(new Student("Przemysław","Stokłosa"+i));
    }

    @Autowired
    StudentRepository repository;

    @RequestMapping("")
    String getInfo(){
        return "info";
    }

    @RequestMapping("linearEquation")
    String getEquationInfo(){
        return "Program zwraca wyniki funkcji y=a*x+b";
    }

    @RequestMapping("add")
    Double add(
            @RequestParam(value = "x",defaultValue = "0.0") Double x,
            @RequestParam(value = "y", defaultValue = "1.0") Double y){
        return x+y;
    }

    @RequestMapping("array")
    List<Integer> getArray(){
        return array;
    }

    @RequestMapping("array/{i}")
    Integer getArrayElement(@PathVariable("id") int i){
        return array.get(i);
    }

    @RequestMapping("student/{id}")
    Student getStudent(@PathVariable("id") int i){
        return students.get(i);
    }

    @RequestMapping("addStudent")
    String addStudent(){
        repository.save(new Student("Przemysław","Stoklosa"));
        return "Poprawnie dodano studenta";
    }

    @RequestMapping("students")
    Iterable<Student> getStudents(){
        return repository.findAll();
    }
}
