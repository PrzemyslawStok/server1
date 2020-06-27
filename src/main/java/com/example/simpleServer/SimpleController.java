package com.example.simpleServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @RequestMapping("")
    String getInfo(){
        return "info";
    }

    @RequestMapping("linearEquation")
    String getEquationInfo(){
        return "Program zwraca wyniki funkcji y=a*x+b";
    }
}
