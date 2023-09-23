package com.luv2code.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class FutbollCoach implements Coach{

    public FutbollCoach() {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run 5 laps";
    }
}
