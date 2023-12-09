package com.core;

import java.time.LocalDate;

public class Doctor implements Comparable<Doctor> {
	// Doctor class contains :(DocID int, Dname string, email string, Degree string,
	// joining_date sdf, salary double, experience int, 

	// Department: enum(ORTHO, PEDIATRICS, PHYSIIOTHEROPY, GASTROLOGY)
	private int doctId;
	private String dname;
	private String email;
	private String degree;
	private LocalDate joininDate;
	private double salary;
	private int experiance;
	private Department dept;

	public Doctor(int doctId, String dname, String email, String degree, LocalDate joininDate, double salary,
			int experiance, Department dept) {
		super();
		this.doctId = doctId;
		this.dname = dname;
		this.email = email;
		this.degree = degree;
		this.joininDate = joininDate;
		this.salary = salary;
		this.experiance = experiance;
		this.dept = dept;
	}

	public int getDoctId() {
		return doctId;
	}

	public String getDname() {
		return dname;
	}

	public String getEmail() {
		return email;
	}

	public String getDegree() {
		return degree;
	}

	public LocalDate getJoininDate() {
		return joininDate;
	}

	public double getSalary() {
		return salary;
	}

	public int getExperiance() {
		return experiance;
	}

	public Department getDept() {
		return dept;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Doctor)
			return ((Doctor) o).getDoctId() == doctId;
		else
			return false;
	}

	
	@Override
	public int compareTo(Doctor o) {
		return ((Integer)this.doctId).compareTo(o.doctId);
		
	}
	
	
	@Override
	public String toString() {
		return "Doctor [doctId=" + doctId + ", dname=" + dname + ", email=" + email + ", degree=" + degree
				+ ", joininDate=" + joininDate + ", salary=" + salary + ", experiance=" + experiance + ", dept=" + dept
				+ "]";
	}

}
