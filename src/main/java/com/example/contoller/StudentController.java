package com.example.contoller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import com.example.service.companyadmin.CityService;
import com.example.service.companyadmin.DepartmentService;
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

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService, CityService cityService, DepartmentService departmentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.cityService = cityService;
        this.departmentService = departmentService;
    }


    @GetMapping("/students")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.readAllStudents());
        return "/courses/students/studentsList";
    }

    @GetMapping("/addNewStudent")
    public String getAddNewStudent(Model model) {
        model.addAttribute("cities", cityService.readAllCities());
        model.addAttribute("department", departmentService.readAllDepartments());
        return "/courses/students/addStudent";
    }


    @PostMapping("/addNewStudent")
    public RedirectView postAddNewStudent(@Valid @ModelAttribute Student newStudent) {
        studentRepository.save(newStudent);
        return new RedirectView("students");
    }

/*    @PostMapping("/addStudent")
    public RedirectView postAddStudent(@ModelAttribute Student newStudent) {
        studentService.addStudent(newStudent);
        return new RedirectView("students");
    }*/

    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable String id, Model model) {
        model.addAttribute("students", studentService.readStudent(Long.parseLong(id)));
        return "/courses/students/editStudent";
    }

    @PostMapping("/students/{id}")
    public RedirectView getEditStudent(@PathVariable String id, @ModelAttribute Student student) {
        studentRepository.save(student);
        return new RedirectView("students/{id}");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public RedirectView deleteStudent(@PathVariable String id, @ModelAttribute Student student) {
        studentRepository.delete(student);
        return new RedirectView("student/{id}");
    }


    @GetMapping("/studentTest")
    public Student getStudent() {
        return studentService.readStudentById(1L);
    }


}
