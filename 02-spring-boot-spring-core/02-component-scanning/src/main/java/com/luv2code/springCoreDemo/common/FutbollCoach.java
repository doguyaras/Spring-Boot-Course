package com.luv2code.springCoreDemo.common;

//@Component
public class FutbollCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 5 laps";
    }
}
