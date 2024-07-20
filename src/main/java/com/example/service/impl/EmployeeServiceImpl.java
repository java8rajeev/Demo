package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.exception.StudentNotFoundException;
import com.example.repo.IEmployeeRepo;
import com.example.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public Integer saveEmp(Employee emp) {
		emp=repo.save(emp);
		return emp.getEmpId();
	}

	@Override
	public void deleteEmp(Integer id) {
		repo.delete(getOneEmp(id));
		
	}

	@Override
	public void updateEmp(Employee emp) {
		if(emp.getEmpId()==null&& !repo.existsById(emp.getEmpId())) 
			throw new StudentNotFoundException("Employee '"+emp.getEmpId()+"' not exist"); 
		else
			repo.save(emp);
		
	}

	@Override
	public Employee getOneEmp(Integer id) {
		return repo.findById(id).orElseThrow(
				()->new StudentNotFoundException("Student '"+id+"' not exist")
				);
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> list= repo.findAll();
		return list;
	}

}
