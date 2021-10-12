package com.example.contoller;


import com.example.appstarter.user.User;
import com.example.appstarter.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private UserRepository userRepository;
@Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = { "/"})
    public String index(Model model) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        User user=userRepository.findById(authentication.getName()).get();
        model.addAttribute("name",user.getName());
        return "index";
    }






}
