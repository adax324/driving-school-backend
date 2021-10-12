package com.example.appstarter.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signin")
    public String getSignin(){
        return "/loginPages/login";
    }
    @GetMapping("/permissions")
    public String getPermissions(){
        return "/admin/utility/permissions";
    }
    @GetMapping("/signup")
    public String getSignUp(Model model){
        model.addAttribute("user",new User());
        return "/admin/utility/register";
    }
    @PostMapping("/signup")
    public String postSignUp(@Valid User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "/admin/utility/register";
        }
        userService.addUser(user);

        return "/admin/utility/register";
    }
}
