package com.te.designpattern.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.namespace.QName;

import com.mysql.cj.Query;
import com.te.designpattern.hibernate.dto.Employee;

public class EmployeeImplementing implements EmployeeInterface {
	static Scanner sc = new Scanner(System.in);

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = new Connection().getConnection();
			transaction = manager.getTransaction();
			System.out.println("Enter the name to be updated");
			String name = sc.next();
			employee.setName(name);
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (manager != null)
				manager.close();

		}

	}

	@Override
	public void delete(Employee employee) {

		// TODO Auto-generated method stub
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = new Connection().getConnection();
			transaction = manager.getTransaction();
			javax.persistence.Query query=manager.createQuery("delete from Employee where id=:id");
			query.setParameter("id", employee.getId());
			
			transaction.begin();
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (manager != null)
				manager.close();

		}

	}

	@Override
	public void select(Employee employee) {
		// TODO Auto-generated method stub

		System.out.println(employee);

	}

	@Override
	public void create() {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = new Connection().getConnection();
			transaction = manager.getTransaction();
			Employee employee = new Employee();
			System.out.println("Enter the name ");
			employee.setName(sc.next());
			System.out.println("Enter the sal");
			employee.setSal(sc.nextDouble());
			System.out.println("enter the gender");
			employee.setGender(sc.next());
			System.out.println("Enter the phono");
			employee.setPhone_no(sc.nextLong());
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (manager != null)
				manager.close();

		}

	}

}
