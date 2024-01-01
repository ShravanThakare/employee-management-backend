package com.EmpSystem.Backend.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.EmpSystem.Backend.Entities.Employee;
import com.EmpSystem.Backend.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeerepository;

    @Override
    public List<Employee> getall() {
        return employeerepository.findAll();
    }

    @Override
    public List<Employee> addemp(Employee emp) {
        employeerepository.save(emp);
        return employeerepository.findAll();
    }

    @Override
    public Employee updateemp(Employee emp, int id) {
        try {
            Employee employee = employeerepository.getById(id);

            if (employee != null) {
                employee.setName(emp.getName());
                employee.setEmail(emp.getEmail());
                employee.setAddress(emp.getAddress());
                employee.setPhonenumber(emp.getPhonenumber());
                employee.setSalary(emp.getSalary());

                employeerepository.save(employee);

                return employee;
            }
        } catch (EntityNotFoundException e) {
            // Handle the case where the entity with the given ID is not found
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        } 

        return null;
    }
    
    
    public boolean deleteEmp(int id) {
        Employee employee = employeerepository.findById(id).orElse(null);

        if (employee != null) {
            employeerepository.delete(employee);
            return true;
        }

        return false;
    }
    
    
    
}
