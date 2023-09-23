package com.luv2code.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class FutbollCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 5 laps";
    }
}
