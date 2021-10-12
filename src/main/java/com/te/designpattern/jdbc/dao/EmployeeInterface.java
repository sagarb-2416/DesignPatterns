package com.te.designpattern.jdbc.dao;

import java.sql.ResultSet;

public interface EmployeeInterface {

	void update(int id);
	void delete(int id);
	void select(ResultSet rs);
	void create();

}
