package com.EmpSystem.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmpSystem.Backend.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
