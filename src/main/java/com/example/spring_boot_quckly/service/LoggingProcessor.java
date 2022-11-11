package com.example.spring_boot_quckly.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class LoggingProcessor {
    private final UserManagerService userManagerService;
    private final LoginCounterService loginCounterService;
    private String username;
    private String password;

    public LoggingProcessor(UserManagerService userManagerService, LoginCounterService loginCounterService) {
        this.userManagerService = userManagerService;
        this.loginCounterService = loginCounterService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login() {
        String login = this.getUsername();
        String pass = this.getPassword();
        loginCounterService.incrementCounter();

        if ("qqq".equals(login) && "qqq".equals(pass)) {
            userManagerService.setUserName(login);
            return true;
        }
        if ("www".equals(login) && "www".equals(pass)) {
            userManagerService.setUserName(login);
            return true;
        }
        return false;
    }
}
