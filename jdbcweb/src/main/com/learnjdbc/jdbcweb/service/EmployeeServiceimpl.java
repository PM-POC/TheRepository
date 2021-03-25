package com.learnjdbc.jdbcweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.learnjdbc.jdbcweb.dataccess.model.EmployeeDataAccess;

import com.learnjdbc.jdbcweb.model.Employee;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired 
	EmployeeDataAccess employeeDataAccess;

	@Override
	public List<Employee> getAllEmployees(){
		
		return employeeDataAccess.getAllEmployees();
	}
}
