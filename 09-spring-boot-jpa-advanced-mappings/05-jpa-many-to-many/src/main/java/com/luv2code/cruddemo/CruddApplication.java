package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDA0;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDA0 appDA0) {
        return runner -> {

            // createCourseAndStudents(appDA0);
            // findCourseAndStudents(appDA0);
            // findStudentAndCourses(appDA0);
            // addMoreCoursesForStudent(appDA0);
            // deleteCourse(appDA0);
            deleteStudentById(appDA0);

        };
    }

    private void deleteStudentById(AppDA0 appDA0) {

        int theId = 4;
        System.out.println("Deleting student id: "+theId);
        appDA0.deleteStudentById(theId);

        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(AppDA0 appDA0) {

        int theId = 3;
        Student tempStudent = appDA0.findStudentAndCourseByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");

        // add courses to student
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Updating student: " + tempStudent);
        System.out.println("Associated courses: " + tempStudent.getCourses());

        appDA0.update(tempStudent);

        System.out.println("Done!");
    }

    private void findStudentAndCourses(AppDA0 appDA0) {

        int theId = 2;
        Student student = appDA0.findStudentAndCourseByStudentId(theId);

        System.out.println("Loaded student: " + theId);
        System.out.println("Loaded courses: " + student.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDA0 appDA0) {

        int theId = 10;
        Course tempCourse = appDA0.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDA0 appDA0) {

        // create a course
        Course tempCourse = new Course("Guitar Course");

        // create the students
        Student tempStudent1 = new Student("Isabel", "Aviva", "doguyaras@hotmail.com");
        Student tempStudent2 = new Student("Hype", "Hunter", "john@hotmail.com");

        // add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        // save the course and associated students
        System.out.println("Saving the course: " + tempCourse);
        System.out.println("Associated students: " + tempCourse.getStudents());

        appDA0.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDA0 appDA0) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);
        appDA0.deleteCourseById(theId);

    }

    private void retrieveCourseAndReviews(AppDA0 appDA0) {

        int theId = 10;
        // get the course and reviews
        Course course = appDA0.findCourseAndReviewsByCourseId(theId);
        // print the course
        System.out.println("Course found by id: " + course);
        // print the reviews
        System.out.println("Reviews: " + course.getReviews());

        System.out.println("Done!");

    }

    private void createCourseAndReviews(AppDA0 appDA0) {

        // create a course
        Course tempCourse = new Course("Pacman - How To Score One Million Points");
        // add some reviews
        tempCourse.addReview(new Review("Great course...Loved it!"));
        tempCourse.addReview(new Review("Cool course... job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
        // save the course ... and leverage the cascade all
        System.out.println("Saving the course..");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDA0.save(tempCourse);
        System.out.println("Done!");
    }

    private void deleteCourse(AppDA0 appDA0) {
        int theId = 10;
        System.out.println("Deleting course by id: " + theId);
        appDA0.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void findCourseById(AppDA0 appDA0) {

        int theId = 10;
        // find the course
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDA0.findCourseById(theId);
        System.out.println("Course information: " + tempCourse);
        System.out.println("Course instructor information: " + tempCourse.getInstructor());

    }

    private void updateCourse(AppDA0 appDA0) {

        int theId = 10;
        // find the course
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDA0.findCourseById(theId);

        // update the course
        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDA0.update(tempCourse);

        System.out.println("Done!");


    }

    private void updateInstructor(AppDA0 appDA0) {

        int theId = 1;

        //find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDA0.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("TESTER");

        appDA0.update(tempInstructor);

        System.out.println("Done!");

    }

    private void findInstructorWithCoursesJoinFetch(AppDA0 appDA0) {

        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDA0.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
    }

    private void findCoursesForInstructor(AppDA0 appDA0) {

        int theId = 1;
        // find instructor
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDA0.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Find courses for instructor id: " + theId);
        List<Course> courses = appDA0.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDA0 appDA0) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDA0.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDA0 appDA0) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Susan", "Public", "susan@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Video Games");
        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDA0.save(tempInstructor);

        System.out.println("Done!");
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
