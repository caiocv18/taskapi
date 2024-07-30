package com.caiocv18.taskapi.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginView {

    @GetMapping("/")
    public String loginSuccess(@RequestParam(required = false) String param) {
        if ("continue".equals(param)) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tryagain")
    public String tryAgain() {
        return "tryagain";
    }
}