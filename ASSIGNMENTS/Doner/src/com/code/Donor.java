package com.code;

import java.time.LocalDate;

public class Donor {
	private int donorId;
	private String fname;
	private String lname;
	private String phoneNo;
	private String email;
	private String password;
	private String address;
	private double amount;
	private LocalDate donationDate;
	private DonationFrequency donationFreq;
	public Donor(int donorId, String fname, String lname, String phoneNo, String email, String password, String address,
			double amount, LocalDate donationDate, DonationFrequency donationFreq) {
		super();
		this.donorId = donorId;
		this.fname = fname;
		this.lname = lname;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.address = address;
		this.amount = amount;
		this.donationDate = donationDate;
		this.donationFreq = donationFreq;
	}
	
	
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", fname=" + fname + ", lname=" + lname + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", password=" + password + ", address=" + address + ", amount=" + amount
				+ ", donationDate=" + donationDate + ", donationFreq=" + donationFreq + "]";
	}


	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}
	public DonationFrequency getDonationFreq() {
		return donationFreq;
	}
	public void setDonationFreq(DonationFrequency donationFreq) {
		this.donationFreq = donationFreq;
	}	
}
