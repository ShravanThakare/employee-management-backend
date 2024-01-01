package com.EmpSystem.Backend.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmpSystem.Backend.Entities.Employee;
import com.EmpSystem.Backend.Service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/details")
public class Controller {

	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/get")
	public List<Employee> getall(){
		

     return this.employeeservice.getall();     		
	
		
	}
	
	@PostMapping("/addemp")
	public List<Employee> addEmp(@RequestBody Employee emp){
		
		return this.employeeservice.addemp(emp);
		
	}

	
	@PutMapping("updateEmp/{id}")
	public ResponseEntity<String> updateEmp(@RequestBody Employee emp, @PathVariable int id) {
	    try {
	        Employee employee = this.employeeservice.updateemp(emp, id);

	        if (employee != null) {
	            return ResponseEntity.ok("Updated Successfully");
	        }

	      
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id " + id + " not found");
	    } catch (EntityNotFoundException e) {
	       
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id " + id + " not found");
	    } 
	}
	
	@DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable int id) {
        if (employeeservice.deleteEmp(id)) {
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id " + id + " not found");
        }
    }
	}
	



