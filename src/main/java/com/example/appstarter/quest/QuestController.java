package com.example.appstarter.quest;

import com.example.appstarter.city.City;
import com.example.service.EmployeesService;
import com.example.service.StudentService;
import com.example.appstarter.city.CityService;
import com.example.appstarter.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@Controller
@RequestMapping("/quests")
public class QuestController {
    private QuestService questService;
    private CityService cityService;
    private DepartmentService departmentService;
    private StudentService studentService;
    private EmployeesService employeesService;


    @Autowired
    public QuestController(QuestService questService, CityService cityService, DepartmentService departmentService, StudentService studentService, EmployeesService employeesService) {
        this.questService = questService;
        this.cityService = cityService;
        this.departmentService = departmentService;
        this.studentService = studentService;
        this.employeesService = employeesService;
    }

    @GetMapping("/city")
    public String getSelectCity(Model model) {
        model.addAttribute("cities", cityService.readAllCities());
        return "/courses/quest/selectCity";
    }

    @GetMapping("/department")
    public String getSelectDepartment(Model model, @RequestParam Long cityId) {
        City city = cityService.readCityById(cityId);
        model.addAttribute("city", city);
        model.addAttribute("departments", departmentService.readAllDepartmentsByCity(city));

        return "/courses/quest/selectDepartment";
    }

    @GetMapping("/add")
    public String getAddQuest(Model model,
                              @RequestParam Map<String, String> param) {
        setAtributes(model, param);


        return "/courses/quest/addQuest";
    }


    @GetMapping("/add/error")
    public String getAddErrorQuest(Model model, @RequestParam Map<String, String> param) {
        setAtributes(model, param);

        Quest questToFix = getQuestToFixFromParam(param);
        model.addAttribute("questToFix", questToFix);

        //setting errors
        param.remove("cityId");
        param.remove("departmentId");
        model.addAllAttributes(param);
        //


        return "/courses/quest/addQuest";
    }


    @PostMapping("/add")
    public RedirectView postAddQuest(@Valid @ModelAttribute Quest quest, BindingResult bindingResult,
                                     @RequestParam Long cityId, @RequestParam Long departmentId) {
        if (bindingResult.hasErrors()) {
            return redirectToErrorViewWithErrorFields(quest, bindingResult, cityId, departmentId);
        }


        quest.setDepartment(departmentService.readDepartment(departmentId));
        questService.createQuest(quest);
        return new RedirectView("list");

    }

    @GetMapping("/list")
    public String getLessonList(Model model) {
        model.addAttribute("quests", questService.readAllQuests());
        return "/courses/quest/questList";
    }

    @GetMapping("/edit/{id}")
    public String getEditQuest(@PathVariable(name = "id") Long id, Model model) {
        Quest questToEdit = questService.readQuest(id);
        model.addAttribute("questToEdit", questToEdit);

        model.addAttribute("students", studentService.readStudentByDepartmentId(questToEdit.getDepartment()));
        model.addAttribute("instructors", employeesService.readAllInstructorsByDepartment(questToEdit.getDepartment()));
        return "/courses/quest/editQuest";
    }

    @PostMapping("/edit/{id}")
    public RedirectView postEditQuest(@PathVariable(name = "id") Long id, @ModelAttribute Quest updatedQuest) {
        questService.updateQuest(id, updatedQuest);
        return new RedirectView("../list");
    }

    @PostMapping("/delete/{id}")
    public RedirectView postDeleteQuest(@PathVariable(name = "id") Long id) {
        questService.deleteQuest(id);
        return new RedirectView("../list");
    }

    @GetMapping("/calendar")
    public String getCalendar() {
        return "/courses/quest/questCalendar";
    }

    //utils methods

    private void setAtributes(Model model, @RequestParam Map<String, String> param) {
        Long departmentId = Long.valueOf(param.get("departmentId"));
        Long cityId = Long.valueOf(param.get("cityId"));

        model.addAttribute("cityProperty", cityService.readCityById(cityId));
        model.addAttribute("departmentProperty", departmentService.readDepartment(departmentId));
        model.addAttribute("studentsProperty", studentService.readStudentByDepartmentId(departmentId));
        model.addAttribute("instructorProperty", employeesService.readAllInstructorsByDepartment(departmentId));
    }
    private Quest getQuestToFixFromParam(Map<String, String> param) {
        Quest questToFix = new Quest();
        if (!param.get("instructor").equals("isEmpty")) {
            questToFix.setInstructor(employeesService.readInstructorById(Long.valueOf(param.get("instructor"))));
        }
        if (!param.get("questType").equals("isEmpty")) {
            questToFix.setQuestType(param.get("questType"));
        }
        if (!param.get("date").equals("isNull")) {
            questToFix.setDate(LocalDate.parse(param.get("date")));
        }
        if (!param.get("time").equals("isNull")) {
            questToFix.setTime(LocalTime.parse(param.get("time")));
        }
        if (!param.get("student").equals("isEmpty")) {
            questToFix.setStudent(studentService.readStudent(Long.valueOf(param.get("student"))));
        }
        return questToFix;
    }

    private RedirectView redirectToErrorViewWithErrorFields(Quest quest, BindingResult bindingResult, Long cityId, Long departmentId) {
        RedirectView redirectView = new RedirectView("add/error?cityId=" + cityId + "&departmentId=" + departmentId);
        Properties properties = new Properties();
        //
        Map<String, String> fields = quest.getAllFields();
        Set<Map.Entry<String, String>> fieldsEntry = fields.entrySet();
        for (Map.Entry<String, String> fieldEntry : fieldsEntry) {
            properties.setProperty(fieldEntry.getKey(), fieldEntry.getValue());
        }

        //
        List<FieldError> fieldError = bindingResult.getFieldErrors();

        for (FieldError error : fieldError) {
            properties.setProperty(error.getField(), error.getDefaultMessage());
        }
        redirectView.setAttributes(properties);
        return redirectView;
    }

}
