package com.javainuse.service;

import java.util.List;
import java.math.BigDecimal;

import com.javainuse.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
	void getEmployeeById(BigDecimal empid);
}