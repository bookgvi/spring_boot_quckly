package com.example.spring_boot_quckly.service;

import java.util.concurrent.atomic.AtomicInteger;

public class LoginCounterService {
    public static volatile LoginCounterService INSTANCE;

    static {
        setINSTANCE();
    }

    private final AtomicInteger counter = new AtomicInteger(0);

    private LoginCounterService() {
    }

    private static void setINSTANCE() {
        if (INSTANCE == null) {
            synchronized (LoginCounterService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LoginCounterService();
                }
            }
        }
    }

    public int getCounter() {
        return counter.get();
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }
}
