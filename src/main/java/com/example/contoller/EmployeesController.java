package com.example.contoller;

import com.example.appstarter.city.CityService;
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
    private final CityService cityService;

    @Autowired
    public EmployeesController(EmployeesRepository employeesRepository, EmployeesService employeesService, CityService cityService) {
        this.employeesRepository = employeesRepository;
        this.employeesService = employeesService;
        this.cityService = cityService;
    }

    @GetMapping("/employeesList")
    public String getEmployeesList(Model model){
        model.addAttribute("employees", employeesService.readAllEmployees());
        return "/admin/employees/employeesList";}

    @GetMapping("/add")
    public String getAddEmployee(Model model){
        model.addAttribute("cities", cityService.readAllCities());
        return "/admin/employees/addEmployee";}

    @PostMapping("/add")
    public RedirectView postAddEmployee(@ModelAttribute Instructor instructor){
        employeesService.createEmployee(instructor);
        return new RedirectView("employeesList");
    }

    @GetMapping("/edit/{id}")
    public String getEditEmployee(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("employee", employeesService.readInstructorById(id));
        return "/admin/employees/editEmployee";
    }

    @PostMapping("/edit/{id}") // edycja nie dzialala, tworzyla nowy rekord bo w jsp nie wywolywalo tej metody tylko add, w serwise tez byly bledy
    public RedirectView getEditEmployee(@PathVariable(name = "id")Long id, @ModelAttribute Instructor updatedInstructor){
        employeesService.updateEmployee(id, updatedInstructor);
        return new RedirectView("../employeesList");
    }

    @PostMapping("/delete/{id}")
    public RedirectView postDeleteEmployee(@PathVariable(name = "id")Long id){
        employeesService.deleteEmployee(id);
        return new RedirectView("../employeesList");
    }


}
