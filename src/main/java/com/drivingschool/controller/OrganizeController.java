package com.drivingschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organize")
public class OrganizeController {
    @GetMapping("/calendar")
    public String getCalendar(){
        return "organization/calendar";
    }
}
