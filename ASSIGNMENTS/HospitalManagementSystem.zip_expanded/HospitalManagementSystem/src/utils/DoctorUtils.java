package utils;

import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.HashMap;

import com.core.*;
import com.exception.DoctorException;

public class DoctorUtils {

	public static HashMap<Integer, Doctor> populateDoctor() {
		HashMap<Integer, Doctor> doctor = new HashMap<>();
		doctor.put(1001, new Doctor(1001, "Tejas", "abc@123", "MBBS", parse("2010-09-05"), 60000, 4, Department.ORTHO));
		doctor.put(1002,new Doctor(1002, "Sahil", "xyz@456", "MD", parse("2020-05-24"), 75000, 2, Department.PEDIATRICS));
		doctor.put(1003, new Doctor(1003, "Abhijeet", "pqr@789", "BAMS", parse("2019-05-22"), 40000, 2,Department.PHYSIIOTHEROPY));
		return doctor;
	}

	public static void adminSignup(String userid, String password) throws DoctorException {
		if (userid.equals("admin")) {
			if (password.equals("admin")) {
				System.out.println("Login Sucessfull!");
			} else
				throw new DoctorException("Invalid Passwprd");
		} else {
			throw new DoctorException("Invalid UserId");
		}

	}
	
	public static Doctor addDoctor(int doctId, String dname, String email, String degree, String joininDate, double salary,
			int experiance, String dept) {
		Department dep=Department.valueOf(dept);
		LocalDate ld=LocalDate.parse(joininDate);
		Doctor d= new Doctor(doctId, dname, email, degree, ld, salary, experiance, dep);
		return d;
	}

}
