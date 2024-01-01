package com.EmpSystem.Backend.Service;

import java.util.List;

import com.EmpSystem.Backend.Entities.Employee;

public interface EmployeeService {

	public List<Employee> getall();

	public List<Employee> addemp(Employee emp);

	public Employee updateemp(Employee emp,int id);

	public boolean deleteEmp(int id);
	
}
