package com.kth.authTest.controller;

import com.kth.authTest.dao.Employee;
import com.kth.authTest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    EmployeeService service;

    @PostMapping
    public String create(@RequestBody Employee emp){
        return service.createEmployee(emp);
    }

    @GetMapping
    public List<List<Employee>> getAll(){
        return service.getAll();
    }

    @DeleteMapping
    public String delete(@PathVariable int id){
        return service.delete(id);
    }

}
