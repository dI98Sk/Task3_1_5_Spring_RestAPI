package com.skakundima.spring.boot.KataTask_3_1_5.controller;


import com.skakundima.spring.boot.KataTask_3_1_5.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/users")
    public String getSinglePage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("authUser", user);
        return "users";
    }

}
