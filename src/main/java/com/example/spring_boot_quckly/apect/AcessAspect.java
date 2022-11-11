package com.example.spring_boot_quckly.apect;

import com.example.spring_boot_quckly.service.UserManagerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AcessAspect {
    private final UserManagerService userManagerService;

    public AcessAspect(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @Around("execution(* com.example.spring_boot_quckly.controller.*.*(..))")
//    @Around("@annotation(com.example.spring_boot_quckly.annotations.Permit)")
    public Object permitAccessExcludeThis(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object res = proceedingJoinPoint.proceed();
        String sessionUser = userManagerService.getUserName();
        if (res instanceof String) {
            if (!"login".equals(res) && !"/".equals(res) && sessionUser == null) {
                return "redirect:/";
            }
        }
        return res;
    }
}
