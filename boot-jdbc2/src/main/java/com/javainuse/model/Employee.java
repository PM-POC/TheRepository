package com.javainuse.model;

import java.math.BigDecimal;

public class Employee {

	private BigDecimal empId;
	private String empName;
	private String Job;
	private String LastName;
	private String hireDate;
	private BigDecimal salary;
	private BigDecimal comm;
	private BigDecimal deptno;
	
	
	public BigDecimal getEmpId() {
		return empId;
	}

	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getLastname() {
		return LastName;
	}

	public void setLastName(String Lastname) {
		this.LastName = Lastname;
	}

	public String getJob() {
		return Job;
	}
	
	public void setJob(String Job) {
		this.Job = Job;
	}

	public String gethireDate() {
		return hireDate;
	}

	public void sethireDate(String hiredate) {
		this.hireDate = hiredate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
 
	public BigDecimal getdeptno() {
		return deptno;
	}

	public void setdeptno(BigDecimal deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [EMPNO=" + empId + ", empName=" + empName  + ", LasName = "+ LastName +", Job ="+Job+" ,Hiredate ="+ hireDate.toString()+ " , Salary ="+salary +" Commission % = "+comm+", Department ID =" +deptno+"]";
	}

}