package com.kth.authTest.repository;

import com.kth.authTest.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    @Query("Select * from employee where name= :name")
//    Employee findByName(@Param("name") String name);

    boolean findById(int id);
}
