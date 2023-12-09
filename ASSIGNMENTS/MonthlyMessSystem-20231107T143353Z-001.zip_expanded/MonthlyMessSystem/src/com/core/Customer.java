package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7916848065690543011L;
	private int custId;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String address;
	private LocalDate registerDate;
	private LocalDate endPlanDate;
	private String phoneNo;
	private Plan messPlan;
	private double finalAmount;
	private static int count;

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	

	static {
		count = 1001;
	}

	public Customer(String fname, String lname, String email, String password, String address, LocalDate registerDate,
			LocalDate endPlanDate, String phoneNo, Plan messPlan, double finalAmount) {
		super();
		this.custId = count++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registerDate = registerDate;
		this.endPlanDate = endPlanDate;
		this.phoneNo = phoneNo;
		this.messPlan = messPlan;
		this.finalAmount = finalAmount;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getCustId() {
		return custId;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public LocalDate getEndPlanDate() {
		return endPlanDate;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public Plan getMessPlan() {
		return messPlan;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", address=" + address + ", registerDate=" + registerDate + ", endPlanDate=" + endPlanDate
				+ ", phoneNo=" + phoneNo + ", messPlan=" + messPlan + ", finalAmount=" + finalAmount + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			return this.getEmail().equals(((Customer) o).getEmail());
			
		} else
			return false;
	}

	@Override
	public int compareTo(Customer o) {

		return this.getEmail().compareTo(o.getEmail());
	}

}
