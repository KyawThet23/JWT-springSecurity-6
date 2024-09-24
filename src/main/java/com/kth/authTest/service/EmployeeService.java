package com.kth.authTest.service;

import com.kth.authTest.dao.Employee;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee emp);
    List<List<Employee>> getAll();
    String delete(int id);
}
