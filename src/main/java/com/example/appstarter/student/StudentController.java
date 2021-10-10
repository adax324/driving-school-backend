package com.example.appstarter.student;

import com.example.appstarter.city.City;
import com.example.service.EmployeesService;
import com.example.appstarter.city.CityService;
import com.example.appstarter.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;


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


    @GetMapping("/city")
    public String getSelectCity(Model model) {
        model.addAttribute("cities", cityService.readAllCities());
        return "/courses/students/selectCity";
    }

    @GetMapping("/department")
    public String getSelectDepartment(Model model, @RequestParam Long cityId) {
        City city = cityService.readCityById(cityId);
        model.addAttribute("city", city);
        model.addAttribute("departments", departmentService.readAllDepartmentsByCity(city));

        return "/courses/students/selectDepartment";
    }

    @GetMapping("/addStudent")
    public String getAddQuest(Model model,
                              @RequestParam Map<String, String> param) {
        Long departmentId = Long.valueOf(param.get("departmentId"));
        Long cityId = Long.valueOf(param.get("cityId"));

        model.addAttribute("cityProperty", cityService.readCityById(cityId));
        model.addAttribute("departmentProperty", departmentService.readDepartment(departmentId));
        model.addAttribute("studentsProperty", studentService.readStudentByDepartmentId(departmentId));
        model.addAttribute("instructorProperty", employeesService.readAllInstructorsByDepartment(departmentId));


        return "/courses/students/addStudent";
    }

    @GetMapping("/addStudent/error")
    public String getAddErrorStudent(Model model, @RequestParam Map<String, String> param) {
        Long departmentId = Long.valueOf(param.get("departmentId"));
        Long cityId = Long.valueOf(param.get("cityId"));

        model.addAttribute("cityProperty", cityService.readCityById(cityId));
        model.addAttribute("departmentProperty", departmentService.readDepartment(departmentId));
        model.addAttribute("studentsProperty", studentService.readStudentByDepartmentId(departmentId));
        model.addAttribute("instructorProperty", employeesService.readAllInstructorsByDepartment(departmentId));

        Student studentToFix = new Student();
        if (!param.get("instructor").equals("isEmpty")) {
            studentToFix.setInstructor(employeesService.readInstructorById(Long.valueOf(param.get("instructor"))));
        }
        if (!param.get("firstName").equals("isEmpty")) {
            studentToFix.setFirstName(param.get("firstName"));
        }
        if (!param.get("lastName").equals("isEmpty")) {
            studentToFix.setLastName(param.get("lastName"));
        }
        if (!param.get("birthDate").equals("isNull")) {
            studentToFix.setBirthDate(LocalDate.parse(param.get("birthDate")));
        }
        if (!param.get("email").equals("isNull")) {
            studentToFix.setEmail(param.get("email"));
        }
        if (!param.get("phoneNumber").equals("isEmpty")) {
            studentToFix.setPhoneNumber(param.get("phoneNumber"));
        }
        model.addAttribute("studentToFix", studentToFix);

        //setting errors
        param.remove("cityId");
        param.remove("departmentId");
        model.addAllAttributes(param);
        //


        return "/courses/students/addStudent";
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


//    @GetMapping("/addStudent")
//    public String getAddNewStudent(Model model) {
//        model.addAttribute("city", cityService.readAllCities());
//        model.addAttribute("departments", departmentService.readAllDepartments());
//        model.addAttribute("instructors", employeesService.readAllEmployees());
//        model.addAttribute("instructor",employeesService.readAllInstructorsByDepartment(departmentId));
//        return "/courses/students/addStudent";
//    }


    @PostMapping("/addStudent")
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