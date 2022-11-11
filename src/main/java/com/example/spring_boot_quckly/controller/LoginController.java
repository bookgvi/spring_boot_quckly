package com.example.spring_boot_quckly.controller;

import com.example.spring_boot_quckly.annotations.PermitAll;
import com.example.spring_boot_quckly.service.LoggingProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    LoggingProcessor loggingProcessor;

    public LoginController(LoggingProcessor loggingProcessor) {
        this.loggingProcessor = loggingProcessor;
    }

    @PermitAll
    @GetMapping
    public String getLoginPage() {
        return "login.html";
    }

    @PermitAll
    @PostMapping
    public String auth(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loggingProcessor.setUsername(username);
        loggingProcessor.setPassword(password);
        boolean isLoggedIn = loggingProcessor.login();

        String loginStatusMsg = isLoggedIn ? "You are now logged in." : "Login failed!";
        model.addAttribute("message", loginStatusMsg);
        return isLoggedIn ? "redirect:/home" : "login";
    }
}
