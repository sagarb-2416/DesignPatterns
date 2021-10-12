package com.te.designpattern.hibernate.dao;

import com.te.designpattern.hibernate.dto.Employee;

public interface EmployeeInterface {
	
	void update(Employee employee);
	void delete(Employee employee);
	void select(Employee employee);
	void create();
}
