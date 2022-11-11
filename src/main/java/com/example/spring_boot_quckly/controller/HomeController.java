package com.example.spring_boot_quckly.controller;

import com.example.spring_boot_quckly.annotations.PermitAll;
import com.example.spring_boot_quckly.service.LoginCounterService;
import com.example.spring_boot_quckly.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final UserManagerService userManagerService;
    private final LoginCounterService loginCounterService;

    public HomeController(UserManagerService userManagerService, LoginCounterService loginCounterService) {
        this.userManagerService = userManagerService;
        this.loginCounterService = loginCounterService;
    }

    @PermitAll
    @GetMapping({"/home", "/"})
    public String home(@RequestParam(required = false) String logout, Model model) {
        if (logout != null) {
            userManagerService.setUserName(null);
        }
        String userName = userManagerService.getUserName();
        userName = userName == null ? "user" : userName;
        int counter = loginCounterService.getCounter();
        model.addAttribute("userName", userName);
        model.addAttribute("counter", counter);
        return "home.html";
    }
}
