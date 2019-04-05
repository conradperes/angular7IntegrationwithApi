package com.employee.rest.employeeApi.commandline;

import com.employee.rest.employeeApi.Employee;
import com.employee.rest.employeeApi.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class EmployeeCommandLine implements CommandLineRunner {

    @Autowired
    private EmployeeRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        Employee user = new Employee(1L, "Conrad", "Solution CLoud Architect", "777", "99999999");
        userRepository.save(user);


    }
}

