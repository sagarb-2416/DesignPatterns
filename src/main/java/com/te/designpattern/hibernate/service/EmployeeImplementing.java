package com.te.designpattern.hibernate.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.internal.build.AllowSysOut;

import com.te.designpattern.hibernate.dto.Employee;

public class EmployeeImplementing implements EmployeeInterface {
	static Scanner sc = new Scanner(System.in);

	private Employee validate() {

		// TODO Auto-generated method stub
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Employee employee = null;
		try {
			try {
				manager = new Connection().getConnection();
				System.out.println("Enter the emp id");
				employee = manager.find(Employee.class, sc.nextInt());
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				employee=null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (manager != null)
				manager.close();

		}
		return employee;
	}

	@Override
	public void update() {
		Employee employee= validate();
		if(employee == null) {
			System.out.println("id not found");
		}
		else {
			com.te.designpattern.hibernate.dao.EmployeeImplementing employeeImplementing = new com.te.designpattern.hibernate.dao.EmployeeImplementing();
			employeeImplementing.update(employee);	
		}
	}

	@Override
	public void delete() {
	
		// TODO Auto-generated method stub
		Employee employee= validate();
		if(employee == null) {
			System.out.println("id not found");
		}
		else {
			com.te.designpattern.hibernate.dao.EmployeeImplementing employeeImplementing = new com.te.designpattern.hibernate.dao.EmployeeImplementing();
			employeeImplementing.delete(employee);	
		}
	}
		

	

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
		Employee employee= validate();
		if(employee == null) {
			System.out.println("id not found");
		}
		else {
			com.te.designpattern.hibernate.dao.EmployeeImplementing employeeImplementing = new com.te.designpattern.hibernate.dao.EmployeeImplementing();
			employeeImplementing.select(employee);	
		}
	

	}

	@Override
	public void create() {
		com.te.designpattern.hibernate.dao.EmployeeImplementing employeeImplementing = new com.te.designpattern.hibernate.dao.EmployeeImplementing();
		employeeImplementing.create();	
	}

}
