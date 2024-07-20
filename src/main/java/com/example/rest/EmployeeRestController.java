package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.exception.StudentNotFoundException;
import com.example.service.impl.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	//to create one student 
	@PostMapping("/save")
	public ResponseEntity<String> createEmployee(
			@RequestBody @Valid Employee emp) 
	{
		Integer id=service.saveEmp(emp);
		String msg="Employee created with this '"+id+"' number";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	//to fetch one student
	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getOneEmployee(
			@PathVariable("id") Integer id)
	
	{   
		ResponseEntity<Employee> response=null;
		try {
		Employee emp = service.getOneEmp(id);
		response = ResponseEntity.ok(emp);
		}catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
		
	}
	//to delete one student 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(
			@PathVariable("id") Integer id)
	{   
		ResponseEntity<String> response=null;
		try {
		service.deleteEmp(id);
		response=ResponseEntity.ok("Employee '"+id+"' deleted");
		}catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
		
	}
	//to fetch all student
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> list=service.getAllEmp();
		return ResponseEntity.ok(list);
	
		
	}
	//to update one studnet
	@PutMapping("/update")
	public ResponseEntity<String> updateEmp(
			@RequestBody Employee emp)
	{   
		ResponseEntity<String> response=null;
        try {
				service.updateEmp(emp);
		        response=ResponseEntity.ok("Employee '"+emp.getEmpId()+"' updated");
		}catch(StudentNotFoundException e) {
			    e.printStackTrace();
			    throw e;
		}
		return response;
	}

}

    