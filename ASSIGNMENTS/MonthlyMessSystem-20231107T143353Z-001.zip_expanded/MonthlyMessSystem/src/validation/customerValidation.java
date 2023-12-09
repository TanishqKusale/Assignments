package validation;

import java.time.LocalDate;
import java.util.Map;
import exception.*;
import com.core.*;

public class customerValidation {

	public static String checkForDuplicateEmail(Map<String, Customer> cust, String email) throws CustomerException {
		if (!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomerException("Invalid email id!");
		else if (cust.get(email) != null)
			throw new CustomerException("Duplicate Email id");
		return email;
	}

	public static String validatePhoneeNo(String phoneNo) throws CustomerException {
		if (phoneNo.matches("[0-9]{10}"))
			throw new CustomerException("Invalid Phone Number");
		else
			return phoneNo;
	}

	public static void ValidateCustomer(Map<String, Customer> cust, String email, String password)
			throws CustomerException {
		Customer c = cust.get(email);
		if (c == null) {
			throw new CustomerException("Email Id not Exisists");
		} else {
			if (c.getPassword().equals(password))
				System.out.println("Sucessfully login!");
			else
				throw new CustomerException("Wrong Password");
		}
	}

	public static void changePassword(Map<String, Customer> cust, String email, String oldPassword, String newPassword)
			throws CustomerException {
		ValidateCustomer(cust, email, oldPassword);

		cust.get(email).setPassword(newPassword);
		System.out.println("Password Changed!");
	}

	public static double parseAndValidatePlan(String plan, Double amount) throws CustomerException {
		Plan p = Plan.valueOf(plan.toUpperCase());
		if (p.getPlanAmount() == amount)
			return amount;
		else
			throw new CustomerException("Ente right amount for plan!");
	}

	public static LocalDate parseEndPlanDate(Plan plan) {
		if (Plan.MONTHLY != null) {
			return LocalDate.now().plusMonths(1);
		} else if (Plan.QUARTARLY != null) {
			return LocalDate.now().plusMonths(3);
		} else if (Plan.HALFYEAR != null) {
			return LocalDate.now().plusMonths(6);
		} else if (Plan.YEARLY != null) {
			return LocalDate.now().plusYears(1);
		}
		return null;
	}

	public static Customer addNewCustomer(String fname, String lname, String email, String password, String address,
			String phoneNo, String messPlan, double finalAmount, Map<String, Customer> cust) throws CustomerException {
		String mail = checkForDuplicateEmail(cust, email);
		Plan plan = Plan.valueOf(messPlan.toUpperCase());
		LocalDate date = LocalDate.now();
		LocalDate date2 = parseEndPlanDate(plan);

		String phone = validatePhoneeNo(phoneNo);
		double pre = parseAndValidatePlan(messPlan, finalAmount);
//		String fname, String lname, String email, String address,
//		LocalDate endPlanDate, String phoneNo, Plan messPlan, double finalAmount
		return new Customer(fname, lname, email, password, address, date, date2, phone, plan, pre);

	}

}
