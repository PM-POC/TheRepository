package com.learnjdbc.jdbcweb.service ;

import java.util.List;
import com.learnjdbc.jdbcweb.model.Employee;
import org.springframework.stereotype.Service;

@Service 
public interface EmployeeService{
	List <Employee> getAllEmployees();
}

