package com.gl.employee.dao;

import com.gl.employee.model.Employee;

public interface EmployeeDAO {

	public void insert(Employee employee);
	
	public void update(int oldID, Employee newEmployee);
	
	public void delete(int delID);
	
	public void showAll();
	
}
