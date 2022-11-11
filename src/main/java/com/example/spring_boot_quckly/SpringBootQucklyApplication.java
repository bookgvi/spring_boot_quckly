package com.example.spring_boot_quckly;

import com.example.spring_boot_quckly.service.LoginCounterService;
import com.example.spring_boot_quckly.service.UserManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class SpringBootQucklyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQucklyApplication.class, args);
	}

	@Bean
	@SessionScope
	UserManagerService userManagerService() {
		return new UserManagerService();
	}

	@Bean
	LoginCounterService loginCounterService() {
		return LoginCounterService.INSTANCE;
	}
}
