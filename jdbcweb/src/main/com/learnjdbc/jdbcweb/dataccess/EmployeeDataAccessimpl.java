package com.learnjdbc.jdbcweb.dataccess;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.learnjdbc.jdbcweb.model.Employee;
import com.learnjdbc.jdbcweb.dataccess.model.EmployeeDataAccess;


@Repository
public class EmployeeDataAccessimpl implements EmployeeDataAccess{
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List <Employee> getAllEmployees(){
		return jdbcTemplate.query(
				"SELECT employee_id,first_name,last_name,email,hire_date,job_id,nvl(salary,0) as salary, nvl(commission_pct,0) as commission_pct, nvl(manager_id,'') as manager_id, nvl(department_id,'') as department_id FROM hr.employees",
                (rs, rowNum) ->
                        new Employee(
                                rs.getInt("employee_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getDate("hire_date").toString(),
                                rs.getString("job_id"),
                                rs.getBigDecimal("salary"),
                                rs.getBigDecimal("commission_pct"),
                                rs.getInt("manager_id"),
                                rs.getInt("department_id")                                                               
                        		)
					);
			}
}
