package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface IEmployeeService {
	Integer saveEmp(Employee emp);
	void deleteEmp(Integer id);
	void updateEmp(Employee emp);
	Employee getOneEmp(Integer id);
	List<Employee> getAllEmp();

}
