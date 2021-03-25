package com.javainuse.dao;

import java.util.List;
import java.math.BigDecimal;

import com.javainuse.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(BigDecimal empId);
}