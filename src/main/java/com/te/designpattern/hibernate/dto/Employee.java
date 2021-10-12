package com.te.designpattern.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double sal;
	private String gender;
	private long phone_no;
}
