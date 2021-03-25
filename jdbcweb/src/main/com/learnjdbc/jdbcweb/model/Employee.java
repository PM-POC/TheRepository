package com.learnjdbc.jdbcweb.model;

import java.math.BigDecimal;

public class Employee {
	
		
		private int Id;
		private String FirstName;
		private String LastName;
		private String EMail;
		private String HireDate;
		private String Job;
		private BigDecimal Sal;
		private BigDecimal Comm;
		private int Boss;
		private int Dept;
		
		public Employee (int id, String firstname , String lastname , String email, String hiredate,String job, BigDecimal sal, BigDecimal comm, int boss, int dept){
			this.Id= id;
			this.FirstName=firstname;
			this.LastName=lastname;
			this.EMail=email;
			this.HireDate=hiredate;
			this.Job=job;
			this.Sal=sal;
			this.Comm=comm;
			this.Boss=boss;
			this.Dept=dept;
		}
		
		public int getEmpId() {
			return Id;
		}

		public void setEmpId(int empId) {
			this.Id = empId;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstname) {
			this.FirstName = firstname;
		}
		
		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastname) {
			this.LastName = lastname;
		}

		public String getEmail() {
			return EMail;
		}

		public void setEMail(String email) {
			this.EMail = email;
		}

		public String gethireDate() {
			return HireDate;
		}

		public void sethireDate(String hiredate) {
			this.HireDate = hiredate;
		}

		public String getJob() {
			return Job;
		}
		
		public void setJob(String job) {
			this.Job = job;
		}


		public BigDecimal getSalary() {
			return Sal;
		}

		public void setSalary(BigDecimal salary) {
			this.Sal = salary;
		}

		public BigDecimal getComm() {
			return Comm;
		}

		public void setComm(BigDecimal comm) {
			this.Comm = comm;
		}
		public int getboss() {
			return Boss;
		}

		public void setboss(int boss) {
			this.Boss = boss;
		}
	 
		public int getDept() {
			return Dept;
		}

		public void setDept(int deptno) {
			this.Dept = deptno;
		}

		@Override
		public String toString() {
			return "Employee [EMPNO=" + Id + ", empName=" + FirstName +" "+ LastName  + ", Boss = "+ Boss +", Job = "+Job+" , Hiredate = " + HireDate+ " , Salary = " +Sal.toString() +" Comm = " +Comm.toString()+", Dept No = " + Dept +"]";
		}

}


