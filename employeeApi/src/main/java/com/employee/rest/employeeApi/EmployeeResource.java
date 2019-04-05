package com.employee.rest.employeeApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {


    @Autowired
    EmployeeRepository service;



    @PostMapping("/api/employee")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object>  insertEmployee(@Valid @RequestBody Employee employee){
        Employee emp = service.save(employee);
        // CREATED
        // /user/{id}     savedUser.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getEmployeeID()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/api/employee")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Employee>findAll(){
        return service.findAll();
    }

    @DeleteMapping("/api/employee/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteUser(@PathVariable Long id) {

        service.deleteById(id);

    }

    @PutMapping("/api/employee")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object>  updateEmployee(@Valid @RequestBody Employee employee){
       service.save(employee);
        // CREATED
        // /user/{id}     savedUser.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployeeID()).toUri();

        return ResponseEntity.created(location).build();

    }






}
