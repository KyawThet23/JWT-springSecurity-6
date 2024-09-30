package com.kth.authTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;

    @Override
    public String createEmployee(Employee emp) {

//        Employee existUser = repository.findByName(emp.getName());
//        if(existUser != null){
//            return "Employee Name already exists";
//        } else{
            repository.save(emp);
            return "Created successfully";
    }

    @Override
    public List<List<Employee>> getAll() {
        return List.of(repository.findAll());
    }

    @Override
    public String delete(int id) {
            repository.deleteById(id);
            return "Deleted successfully.";
    }
}
