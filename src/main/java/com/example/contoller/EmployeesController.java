package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @GetMapping("/employeesList")
    public String getEmployeesList(){ return "/admin/employees/employeesList";}

    @GetMapping("/addEmployee")
    public String getAddEmployee(){return "/admin/employees/addEmployee";}
}
