package com.kth.authTest.repository;

import com.kth.authTest.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    boolean findByName(String name);
    boolean findById(int id);
}
