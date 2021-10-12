package com.te.designpattern.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeImplementing implements EmployeeInterface {
	static Scanner sc = new Scanner(System.in);

	@Override
	public void update(int id) {

		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			statement = con.prepareCall("Update employee set id= ? where name=?");
			System.out.println("Enter the name to be updated");
			statement.setString(1, sc.next());
			System.out.println("enter the id");
			statement.setInt(2, sc.nextInt());
			int num = statement.executeUpdate();
			if (num == 0)
				System.out.println("EMployee table not updated");
			else {
				System.out.println("Updated");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			statement = con.prepareCall("Delete from employee where id=?");
			System.out.println("enter the id");
			statement.setInt(1, sc.nextInt());
			int num = statement.executeUpdate();
			if (num == 0)
				System.out.println("EMployee table not updated");
			else {
				System.out.println("Deleted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void select(ResultSet rs) {
		Connection con = null;
	Statement statement = null;
	String QUERY="Select * from employee";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			statement = con.createStatement();
	          rs = statement.executeQuery(QUERY);
			while(rs.next()) {
			System.out.println("ID  : " +rs.getInt("id"));
			System.out.println("Gender : "+rs.getString("gender"));
			System.out.println("Name : "+rs.getString("name"));
			System.out.println("Phone_Number "+rs.getLong("phone_no"));
			System.out.println("Salary :" +rs.getDouble("sal"));
			System.out.println("      ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void create() {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			statement = con.prepareCall("insert into employee values(?,?,?,?,?)");
			System.out.println("Enter the id");
			int id = sc.nextInt();
			statement.setInt(1, id);

			System.out.println("enter the gender");
			String Gender = sc.next();
			statement.setString(2, Gender);

			System.out.println("Enter the name ");
			String name = sc.next();

			statement.setString(3, name);

			System.out.println("Enter the phono");
			long phone = sc.nextLong();
			statement.setLong(4, phone);

			System.out.println("Enter the sal");
			double sal = sc.nextDouble();
			statement.setDouble(5, sal);

			int num = statement.executeUpdate();
			if (num == 0)
				System.out.println("EMployee values not inserted");
			else {
				System.out.println("Inserted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
