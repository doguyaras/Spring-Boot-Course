package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="members")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    //Employee findByEmailAndFirstName(String email, String firstName);
    // that's it ... no need to write any code
}
