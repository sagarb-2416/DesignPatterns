package com.te.designpattern.jdbc.dao;

import java.util.Scanner;

import com.te.designpattern.jdbc.service.EmployeeImplementing;

public class Driver {


		public void driverJdbc() {
		Scanner sc = new Scanner(System.in);
		boolean stop = false;

		EmployeeImplementing implementing = new EmployeeImplementing();
		while (!stop) {
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Select");
			System.out.println("5.Exit");
			System.out.println("enter the choice");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				implementing.create();
				break;
			case 2:
				implementing.update();
				break;
			case 3:
				implementing.delete();
				break;
			case 4:
				implementing.select();
				break;
			case 5:
				if (ch == 5) {
					stop = true;
				}
				System.out.println("exited");
				break;
			default:
				System.out.println("Invalid Choice");

			}
		}

	}

}
