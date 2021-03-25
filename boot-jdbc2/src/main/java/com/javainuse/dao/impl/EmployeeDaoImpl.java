package com.javainuse.dao.impl;

import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.EmployeeDao;
import com.javainuse.model.Employee;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
//import oracle.jdbc.*;

/*
Name                                      Null?    Type
		 ----------------------------------------- -------- ----------------------------
		 EMPLOYEE_ID                               NOT NULL NUMBER(6)
		 FIRST_NAME                                         VARCHAR2(20)
		 LAST_NAME                                 NOT NULL VARCHAR2(25)
		 EMAIL                                     NOT NULL VARCHAR2(25)
		 PHONE_NUMBER                                       VARCHAR2(20)
		 HIRE_DATE                                 NOT NULL DATE
		 JOB_ID                                    NOT NULL VARCHAR2(10)
		 SALARY                                             NUMBER(8,2)
		 COMMISSION_PCT                                     NUMBER(2,2)
		 MANAGER_ID                                         NUMBER(6)
		 DEPARTMENT_ID                                      NUMBER(4)
*/
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	final static String DB_URL="jdbc:oracle:thin:@localhost:1521:orcl";
	final static String DB_USER = "HR";
	final static String DB_PASSWORD = "nK28071971";
	
	@Bean
	   public DataSource dataSource() {
	       OracleDataSource dataSource = null;
	       try {
	           dataSource = new OracleDataSource();
	           Properties props = new Properties();
	           props.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
	           props.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);          
	           props.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");  
	           dataSource.setConnectionProperties(props);
	           dataSource.setURL(DB_URL);
	       } catch(Exception e) {
	           e.printStackTrace();
	       }
	       return dataSource;
	   }

	@Bean
	   public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
	       jdbcTemplate.setFetchSize(20000);
	       return jdbcTemplate;
	   }

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO employees " +
				"(EMPLOYEE_ID, FIRST_NAME) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});
	}
	
	@Override
	public void insertEmployees(final List<Employee> employees) {
		String sql = "INSERT INTO employees " + "(EMPLOYEE_ID, FIRST_NAME) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setBigDecimal(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	@Override
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM employees";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Employee> result = new ArrayList<Employee>();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpId((BigDecimal)row.get("EMPLOYEE_ID"));
			emp.setEmpName((String)row.get("FIRST_NAME"));
			emp.setLastName((String)row.get("LAST_NAME"));
			emp.setJob((String)row.get("JOB_ID"));
			emp.sethireDate(row.get("HIRE_DATE").toString());
			emp.setSalary((BigDecimal)(row.get("SALARY")));
			emp.setComm((BigDecimal)(row.get("COMMISSION_PCT")));
			emp.setdeptno((BigDecimal)row.get("DEPARTMENT_ID"));
			result.add(emp);}
		
		return result;
	}

	@Override
	public Employee getEmployeeById(BigDecimal empId) {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getBigDecimal("EMPLOYEE_ID"));
				emp.setEmpName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setJob(rs.getString("JOB_ID"));
				emp.sethireDate(rs.getString("HIRE_DATE"));
				emp.setSalary(rs.getBigDecimal("SALARY"));
				emp.setComm(rs.getBigDecimal("COMMISSION_PCT"));
				emp.setdeptno(rs.getBigDecimal("DEPARTMENT_ID"));
				return emp;
			}
		});
	}
}