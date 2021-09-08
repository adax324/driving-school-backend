package com.drivingschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StudentController {
    @GetMapping("/list")
    public String getStudentList(){
        return "/courses/students/studentsList";
    }
    @GetMapping("/add")
    public String getAddStudent(){
        return "courses/students/addStudent";
    }
}
