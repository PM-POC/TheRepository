package com.learnjdbc.jdbcweb.dataccess.model;

import java.util.List;
import com.learnjdbc.jdbcweb.model.Employee;

public interface EmployeeDataAccess{
	List <Employee> getAllEmployees();
}
