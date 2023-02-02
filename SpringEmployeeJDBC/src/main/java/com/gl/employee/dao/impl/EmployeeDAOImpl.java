package com.gl.employee.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE"+"(EMPLOYEE_ID,EMP_NAME,AGE,SALARY) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql,new Object[] {employee.getEmployeeId(), employee.getEmployeeName(), employee.getAge(), employee.getSalary()});
	}
	
	public void update(int oldID, Employee newEmployee) {
		String sql = "UPDATE EMPLOYEE "+"SET EMPLOYEE_ID = ?, EMP_NAME = ?, AGE = ?, SALARY = ? "+"WHERE EMPLOYEE_ID = ?";
		jdbcTemplate.update(sql,new Object[] {newEmployee.getEmployeeId(), newEmployee.getEmployeeName(), newEmployee.getAge(), newEmployee.getSalary(), oldID});
	}
	
	public void delete(int delID) {
		String sql = "DELETE from EMPLOYEE WHERE EMPLOYEE_ID = ?";
		jdbcTemplate.update(sql,new Object[] {delID});
	}
	
	public void showAll() {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper());
		Iterator<Employee> itr = employees.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	
}
