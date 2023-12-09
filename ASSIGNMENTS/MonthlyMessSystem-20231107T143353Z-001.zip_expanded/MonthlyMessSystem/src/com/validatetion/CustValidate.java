package com.validatetion;

import java.time.LocalDate;
import java.util.EmptyStackException;
import java.util.HashMap;
import com.core.*;

import exception.*;

public class CustValidate {
	// valiating email
	public static String validateEmail(HashMap<String, Customer> cust, String email) throws Exception

	{
		if (!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new Exception("Invalid Email");
		else if (cust.get(email) != null)
			throw new Exception("Dublicate Email");
		return email;
	}

	// validating phone
	public static String validatePhone(String Phone) throws Exception {
		if (Phone.matches("[0-9]{10}"))
			throw new Exception("Enter Valid Phone NO");
		return Phone;

	}

	public static void validateCustomer(HashMap<String, Customer> cust, String email, String Password)
			throws Exception {
		Customer c = cust.get(email);
		if (c == null)
			throw new Exception("Enter Valid Email");
		else if (c.getEmail().equals(email))
			System.out.println("Successfull Login");
		else
			throw new Exception("Wrong Password");
	}

	public static void changepassword(HashMap<String, Customer> cust, String email, String oldPassword,
			String newPassword) throws Exception {
		validateCustomer(cust, email, oldPassword);
		cust.get(email).setPassword(newPassword);
		System.out.println("Password Changed Successfull");
	}

	public static double validatePlan(String plan, Double Amount) {
		Plan p = Plan.valueOf(plan.toUpperCase());
		if (p.getPlanAmount() == Amount)
			return Amount;
		else
			System.out.println("Enter Valid Amount");
		return Amount;

	}

	// String fname, String lname, String email, String password, String address,
	// LocalDate registerDate,
	// LocalDate endPlanDate, String phoneNo, Plan messPlan, double finalAmount
	public static Customer AddCustoemr(HashMap<String, Customer> cust, String fname, String lname, String email,
			String password, String address, LocalDate registerDate, LocalDate endPlanDate, String phoneNo,
			Plan messPlan, double finalAmount) {
		String Email = validateEmail(cust, email);
		Plan plan = Plan.valueOf(plan.toUpperCase());
		String phone = validatePhone(phoneNo);
		return new Customer(fname, lname, email, password, address, registerDate, endPlanDate, phoneNo, messPlan,
				finalAmount);

	}

}
