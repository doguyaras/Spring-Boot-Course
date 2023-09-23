package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.IStudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IStudentDAO studentDAO) {

        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //removeStudent(studentDAO);
            //deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(IStudentDAO studentDAO) {

        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: "+numRowsDeleted);
    }

    private void removeStudent(IStudentDAO studentDAO) {

        // delete the student
        int studentId = 3;
        System.out.println("Deleting student id: "+studentId);
        studentDAO.delete(studentId);

        // new student list
        System.out.println("New student list: ");
        List<Student> students = studentDAO.findAll();
        for (Student theStudents:students){
            System.out.println(theStudents);
        }


    }

    private void updateStudent(IStudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);
        System.out.println("Updating student...");

        // change first name to "Scooby"
        myStudent.setFirstName("Scooby");
        studentDAO.update(myStudent);

        // display updated student
        System.out.println("Updated Student: " + myStudent);

        /*int studentId = 2;
        Student myStudent = studentDAO.findById(studentId);
        myStudent.setLastName("Dooo");
        studentDAO.update(myStudent);
        System.out.println(myStudent);*/

    }

    private void queryForStudentsByLastName(IStudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Lock");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(IStudentDAO studentDAO) {

        // get list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudens : theStudents) {
            System.out.println(tempStudens);
        }
    }

    private void readStudent(IStudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@hotmail.com");

        // save the student
        System.out.println("Saving the student..");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);

        /*Student findStudent = studentDAO.findById(2);
        System.out.println("Found the student: "+findStudent);
*/
    }

    private void createMultipleStudents(IStudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("Lisa", "Smith", "lisa@hotmail.com");
        Student tempStudent2 = new Student("Anna", "Tyler", "anna@hotmail.com");
        Student tempStudent3 = new Student("West", "Lock", "west@hotmail.com");

        // save the student objects
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());


    }

    private void createStudent(IStudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Dogu", "Yaras", "doguyaras@hotmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }


}
