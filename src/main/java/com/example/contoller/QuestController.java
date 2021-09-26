package com.example.contoller;

import com.example.model.Quest;
import com.example.model.companyadmin.City;
import com.example.service.StudentService;
import com.example.service.companyadmin.CityService;
import com.example.service.QuestService;
import com.example.service.companyadmin.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/quest")
public class QuestController {
    private QuestService questService;
    private CityService cityService;
    private DepartmentService departmentService;
    private StudentService studentService;


    @Autowired
    public QuestController(QuestService questService, CityService cityService, DepartmentService departmentService, StudentService studentService) {
        this.questService = questService;
        this.cityService = cityService;
        this.departmentService = departmentService;
        this.studentService = studentService;
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
    public String getAddQuest(Model model, @RequestParam Long cityId, @RequestParam Long departmentId) {
        model.addAttribute("city", cityService.readCityById(cityId));
        model.addAttribute("department", departmentService.readDepartment(departmentId));
        model.addAttribute("students",studentService.getAllStudents());
        return "/courses/quest/addQuest";
    }

    @PostMapping("/add")
    public RedirectView postAddQuest(@ModelAttribute Quest quest, @RequestParam Long departmentId) {
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
        model.addAttribute("questToEdit", questService.readQuest(id));
        return "/courses/quest/editQuest";
    }

    @PostMapping("/edit/{id}")
    public RedirectView postEditQuest(@PathVariable(name = "id") Long id, @ModelAttribute Quest updatedQuest) {
        questService.updateQuest(id, updatedQuest);
        return new RedirectView("list");
    }

    @GetMapping("/calendar")
    public String getCalendar() {
        return "/courses/quest/questCalendar";
    }

}
