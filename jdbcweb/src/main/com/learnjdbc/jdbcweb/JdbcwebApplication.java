package com.learnjdbc.jdbcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.learnjdbc.jdbcweb.service.EmployeeService;
import com.learnjdbc.jdbcweb.model.Employee;

@SpringBootApplication
public class JdbcwebApplication implements CommandLineRunner{
	
	@Autowired 
	EmployeeService employeeservice;

	public static void main(String[] args) {
		SpringApplication.run(JdbcwebApplication.class, args);
	}
	@Override
    public void run(String... args) {
         System.out.println("StartApplication...");
         List<Employee> emp;
         emp = employeeservice.getAllEmployees();
         emp.stream().forEach((e) -> System.out.println(e.toString()));
    }
}
