package com.luv2code.springCoreDemo;

import org.springframework.stereotype.Component;

public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
