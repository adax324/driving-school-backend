package com.example.contoller;

import com.example.model.Instructor;
import com.example.repository.EmployeesRepository;
import com.example.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesRepository employeesRepository;
    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesRepository employeesRepository, EmployeesService employeesService) {
        this.employeesRepository = employeesRepository;
        this.employeesService = employeesService;
    }

    @GetMapping("/employeesList")
    public String getEmployeesList(Model model){
        model.addAttribute("employees", employeesService.readAllEmployees());
        return "/admin/employees/employeesList";}

    @GetMapping("/add")
    public String getAddEmployee(){return "/admin/employees/addEmployee";}

    @PostMapping("/add")
    public RedirectView postAddEmployee(@ModelAttribute Instructor instructor){
        employeesService.createEmployee(instructor);
        return new RedirectView("employeesList");
    }
}
