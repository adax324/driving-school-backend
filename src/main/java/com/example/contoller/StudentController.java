package com.example.contoller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.EmployeesService;
import com.example.service.StudentService;
import com.example.appstarter.city.CityService;
import com.example.appstarter.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final CityService cityService;
    private final DepartmentService departmentService;
    private final EmployeesService employeesService;


    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService, CityService cityService, DepartmentService departmentService, EmployeesService employeesService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.cityService = cityService;
        this.departmentService = departmentService;
        this.employeesService = employeesService;
    }


    @GetMapping("/students")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.readAllStudents());
        return "/courses/students/studentsList";
    }

//    @GetMapping("/addNewStudent")
//    public String getAddNewStudent(Model model, @RequestParam Long cityId, @RequestParam Long departmentId) {
//        model.addAttribute("city", cityService.readCityById(cityId));
//        model.addAttribute("department", departmentService.readDepartment(departmentId));
//      //  model.addAttribute("students",studentService.readAllStudents());
//      //  model.addAttribute("students",studentService.readStudentByDepartmentId(departmentId));
//        model.addAttribute("instructors",employeesService.readAllInstructorsByDepartment(departmentId));
//        return "/courses/students/addStudent";
//    }


    @GetMapping("/addNewStudent")
    public String getAddNewStudent(Model model) {
        model.addAttribute("city", cityService.readAllCities());
        model.addAttribute("departments", departmentService.readAllDepartments());
        model.addAttribute("instructors", employeesService.readAllEmployees());
        //model.addAttribute("instructor",employeesService.readAllInstructorsByDepartment(departmentId));
        return "/courses/students/addStudent";
    }


    @PostMapping("/addNewStudent")
    public RedirectView postAddStudent(@Valid @ModelAttribute Student student) {
        studentService.createStudent(student);
        return new RedirectView("students");
    }


    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("students", studentService.readStudentById(id));
        model.addAttribute("cities", cityService.readAllCities());
        model.addAttribute("department", departmentService.readAllDepartments());
        model.addAttribute("instructors", employeesService.readAllEmployees());
        return "/courses/students/editStudent";
    }

    @PostMapping("/editStudent/{id}")
    public RedirectView postEditStudent(@PathVariable Long id, @ModelAttribute Student updateStudent) {
        studentService.updateStudent(id, updateStudent);
        return new RedirectView("../students");
    }

    @PostMapping("/delete/{id}")
    public RedirectView postDeleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return new RedirectView("../students");
    }
}
