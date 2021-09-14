package com.example.contoller;

import com.example.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class QuestController {
    private QuestService questService;
    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/list")
    public String getLessonList(Model model){
        model.addAttribute("temp",questService.getAllQuests());
        return "/courses/lessons/lessonsList";
    }


}
