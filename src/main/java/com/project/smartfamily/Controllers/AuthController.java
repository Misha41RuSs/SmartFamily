package com.project.smartfamily.Controllers;

import com.project.smartfamily.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute("user") UserDto user) {
        System.out.println("Зарегистрирован: " + user.getFirstName() + " " + user.getPhone());
        return "redirect:/";
    }
}
