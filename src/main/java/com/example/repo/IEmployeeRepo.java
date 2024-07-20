package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer>
{

}
