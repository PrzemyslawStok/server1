package com.example.simpleServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("add")
    Double add(
            @RequestParam(value = "x",defaultValue = "0.0") Double x,
            @RequestParam(value = "y", defaultValue = "1.0") Double y){
        return x+y;
    }
}
