package com.kth.authTest.service;

import com.kth.authTest.dao.Employee;
import com.kth.authTest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;

    @Override
    public String createEmployee(Employee emp) {

        if(repository.findByName(emp.getName())){
            return "Employee Name already exists";
        } else{
            repository.save(emp);
            return "Created successfully";
        }
    }

    @Override
    public List<List<Employee>> getAll() {
        return List.of(repository.findAll());
    }

    @Override
    public String delete(int id) {
        if(repository.findById(id)){
            repository.deleteById(id);
            return "Deleted successfully.";
        } else{
            return "User doesn't exists.";
        }
    }
}
