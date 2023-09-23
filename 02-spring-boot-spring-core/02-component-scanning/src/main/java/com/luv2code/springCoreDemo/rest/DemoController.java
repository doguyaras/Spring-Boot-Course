package com.luv2code.springCoreDemo.rest;

import com.luv2code.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection

    @Autowired
    public void setCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }

    /*@Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
