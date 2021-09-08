package com.drivingschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LessonController {
    @GetMapping("/abc")
    public String getCalendar(){
       for (int i=10;i>0;i--){
           System.out.println("Jesteś królem");
       }
        return "/courses/lessons/lessonsCalendar";
    }
}
