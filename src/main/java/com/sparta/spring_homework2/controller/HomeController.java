package com.sparta.spring_homework2.controller;

import com.sparta.spring_homework2.model.UserRoleEnum;
import com.sparta.spring_homework2.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("loginStatus", true);

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        return "index";
    }

    @GetMapping("/home")
    public String mainWithoutLogin() {
        return "index";
    }
}