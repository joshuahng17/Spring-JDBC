package com.gl.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gl.employee.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee(rs.getInt("EMPLOYEE_ID"), 
										rs.getString("EMP_NAME"), 
										rs.getInt("AGE"), 
										rs.getInt("SALARY"));
		return employee;
	}

	
}
