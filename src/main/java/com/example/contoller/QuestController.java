package com.example.contoller;

import com.example.model.Quest;
import com.example.model.companyadmin.City;
import com.example.service.companyadmin.CityService;
import com.example.service.QuestService;
import com.example.service.companyadmin.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("quests",questService.getAllQuests());
        return "/courses/lessons/lessonsList";
    }
    @GetMapping("/selectcity")
    public String getSelectCity(Model model){
        model.addAttribute("cities",cityService.getAllCities());
        return "/courses/lessons/selectCity";
    }
    @GetMapping("/selectdepartment")
    public String getSelectDepartment(Model model,@RequestParam Long cityId){
        City city=cityService.getCityById(cityId);
        model.addAttribute("city",city);
        model.addAttribute("departments",departmentService.readAllDepartmentsByCity(city));
        return "/courses/lessons/selectDepartment";
    }
    @GetMapping("/addquest")
    public String getAddQuest(Model model,@RequestParam Long cityId,@RequestParam Long departmentId){
        model.addAttribute("city",cityService.getCityById(cityId));
        model.addAttribute("department",departmentService.readDepartment(departmentId));
        return "/courses/lessons/addLesson";
    }
    @PostMapping("/addquest")
    public RedirectView postAddQuest(@ModelAttribute Quest quest,@RequestParam Long departmentId){
        quest.setDepartmentId(departmentId);
        questService.addQuest(quest);
        return new RedirectView("list");

    }


}
