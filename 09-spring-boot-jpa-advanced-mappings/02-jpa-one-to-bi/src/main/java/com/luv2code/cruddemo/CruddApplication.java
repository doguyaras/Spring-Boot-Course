package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDA0;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDA0 appDA0) {
        return runner -> {

            // createInstructor(appDA0);
            // findInstructor(appDA0);
            // deleteInstructor(appDA0);
            // findInstructorDetail(appDA0);
            deleteInstructorDetail(appDA0);
        };
    }

    private void deleteInstructorDetail(AppDA0 appDA0) {
        int theId = 3;
        System.out.println("Deleting instructor detail id: " + theId);

        appDA0.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDA0 appDA0) {
        int theId = 1;
        System.out.println("Finding instructor detail id: " + theId);

        InstructorDetail tempInstructorDetail = appDA0.findInstructorDetailById(theId);
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDA0 appDA0) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDA0.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDA0 appDA0) {
        // One-to-One Uni-Directional
        int theId = 2;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDA0.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDA0 appDA0) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Cold", "Dogu", "dogu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Gaming!!!");

        /*// create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu","Patel","madhu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Guitar");*/

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDA0.save(tempInstructor);

        System.out.println("Done!");
    }

}
