package com.te.designpattern.main;

import java.util.Scanner;

import com.te.designpattern.jdbc.dao.Driver;

public class MainDriver {
	public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
	com.te.designpattern.jdbc.dao.Driver driverjdbc=new com.te.designpattern.jdbc.dao.Driver();
	
	
	com.te.designpattern.hibernate.dao.Driver driverhibernate=new com.te.designpattern.hibernate.dao.Driver();
	
	System.out.println("1.for jdbc");
	System.out.println("2.for hibernate");
	
	System.out.println("Enter the choice");
	int ch=sc.nextInt();
	
	switch(ch) {
	case 1: driverjdbc.driverJdbc();
	break;
	case 2:driverhibernate.driverHibernate();
	break;
	default: System.out.println("Invalid Choice");
	}
	
	}	
	
}
