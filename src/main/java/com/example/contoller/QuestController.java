package com.example.contoller;

import com.example.model.Quest;
import com.example.service.companyadmin.CityService;
import com.example.service.QuestService;
import com.example.service.companyadmin.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/lesson")
public class QuestController {
    private QuestService questService;
    private CityService cityService;
    private DepartmentService departmentService;
    @Autowired
    public QuestController(QuestService questService, CityService cityService, DepartmentService departmentService) {
        this.questService = questService;
        this.cityService = cityService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String getLessonList(Model model){
        model.addAttribute("temp",questService.getAllQuests());
        return "/courses/lessons/lessonsList";
    }
    @GetMapping("/add")
    public String getAddQuest(Model model){
        model.addAttribute("cities",cityService.getAllCities());
        model.addAttribute("departments",departmentService.readAllDepartments());
        return "/courses/lessons/addLesson";
    }
    @PostMapping("/add")
    public RedirectView postAddQuest(@ModelAttribute Quest quest){

        questService.addQuest(quest);
        return new RedirectView("list");

    }


}
