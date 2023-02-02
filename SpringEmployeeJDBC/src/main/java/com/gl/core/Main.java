package com.gl.core;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1-Create Employee");
			System.out.println("2-Update Employee");
			System.out.println("3-Delete Employee");
			System.out.println("4-Show All Employees");
			System.out.println("5-Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter the employee ID");
					int empID = sc.nextInt();
					System.out.println("Enter the employee name");
					String empName = sc.next();
					System.out.println("Enter the employee age");
					int empAge = sc.nextInt();
					System.out.println("Enter the employee salary");
					int empSalary = sc.nextInt();
					Employee employee = new Employee(empID, empName, empAge, empSalary);
					employeeDAO.insert(employee);
					break;
				case 2:
					System.out.println("Enter the employee ID to be updated");
					int oldID = sc.nextInt();
					System.out.println("Enter the new Information");
					System.out.println("Enter the employee ID");
					int newID = sc.nextInt();
					System.out.println("Enter the employee name");
					String newName = sc.next();
					System.out.println("Enter the employee age");
					int newAge = sc.nextInt();
					System.out.println("Enter the employee salary");
					int newSalary = sc.nextInt();
					Employee newEmployee = new Employee(newID, newName, newAge, newSalary);
					employeeDAO.update(oldID, newEmployee);
					break;
				case 3:
					System.out.println("Enter the employee ID to be deleted");
					int delID = sc.nextInt();
					employeeDAO.delete(delID);
					break;
				case 4:
					employeeDAO.showAll();
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid Input");
			}
			
		} while(choice != 5);
		sc.close();
	}
	
}
