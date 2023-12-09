package com.validate;

import java.time.LocalDate;
import java.util.Map;

import com.code.DonationFrequency;
import com.code.Donor;
import com.exp.DonorException;

public class ValidateDonor {

	public static void checkDuplicateEmail(Map<String, Donor> map, String email) throws DonorException {
		if (map.containsKey(email)) {
			throw new DonorException("This mail already registered!");
		}
	}

	public static void validateEmailPass(Map<String, Donor> map, String email, String pass) throws DonorException 
	{
		Donor donor = map.get(email);

		if (donor.getEmail().equals(email)) 
		{
			if (donor.getPassword().equals(pass)) 
			{

			} 
			else 
			{
				throw new DonorException("Incorrect Password!");
			}
		} 
		else 
		{
			throw new DonorException("Email not present!");
		}
	}

	public static void checkEmailFormat(String email) throws DonorException {
		if (email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {

		} else {
			throw new DonorException("Incorrect email format!");
		}

	}
	
	public static DonationFrequency parseAndValidateDonationFreq(String donationFreq) throws DonorException
	{
		DonationFrequency df=DonationFrequency.valueOf(donationFreq.toUpperCase());
		if(df==DonationFrequency.MONTHLY || df==DonationFrequency.ONETIME || df==DonationFrequency.YEARLY)
		{
			return df;
		}
		else
		{
			System.out.println(df);
			throw new DonorException("Entered category of donation frequency is not available!");
			
		}
	}
	public static LocalDate parseLocalDate(String date)
	{
		return LocalDate.parse(date);
	}
	
	public static Donor validateAll(Map<String,Donor>map,int donorId, String fname, String lname, String phoneNo, String email, String password, String address,
			double amount, String donationDate, String donationFreq) throws DonorException
	{
		checkEmailFormat(email);
		checkDuplicateEmail(map,email);
		DonationFrequency df=parseAndValidateDonationFreq(donationFreq);
		LocalDate date=parseLocalDate(donationDate);
		
		return new Donor( donorId,  fname,  lname,  phoneNo,  email,  password,  address,
				 amount,  date,  df);
	
	}
}
