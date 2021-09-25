package com.example.contoller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "/courses/students/studentsList";
    }

    @GetMapping("/addNewStudent")
    public String getAddNewStudent() {
        return "/courses/students/addStudent";
    }


    @PostMapping("/addNewStudent")
    public RedirectView postAddNewStudent(@ModelAttribute Student newStudent) {
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
        model.addAttribute("students", studentService.getStudent(Long.parseLong(id)));
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


}
