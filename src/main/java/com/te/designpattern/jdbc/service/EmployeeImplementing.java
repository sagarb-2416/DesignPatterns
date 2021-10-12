package com.te.designpattern.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeImplementing implements EmployeeInterface {

	private ResultSet validate() {
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement statement = con.prepareCall("select * from employee");
			rs = statement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void update() {
		ResultSet rs = validate();
		try {
			if (rs.next()==false) {
				System.out.println("Id not found");
			} else {
				try {
					new com.te.designpattern.jdbc.dao.EmployeeImplementing().update(rs.getInt("id"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		ResultSet rs = validate();
		try {
			if (rs.next() == false) {
				System.out.println("Id not found");
			} else {
				try {
					new com.te.designpattern.jdbc.dao.EmployeeImplementing().delete(rs.getInt("id"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void select() {
		ResultSet rs = validate();
		try {
			if (rs.next() == false) {
				System.out.println("Id not found");
			} else {
				new com.te.designpattern.jdbc.dao.EmployeeImplementing().select(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create() {
			new com.te.designpattern.jdbc.dao.EmployeeImplementing().create();

	}

}
