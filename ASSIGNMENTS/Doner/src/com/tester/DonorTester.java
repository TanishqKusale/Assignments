//101 Neha Sonar 8686 neha@gmail.com 123 nashik 7000 2020-10-09 Yearly

package com.tester;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static com.validate.ValidateDonor.*;
import com.code.DonationFrequency;
import com.code.Donor;

public class DonorTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			Map<String,Donor> map=new HashMap<>();
			boolean exit=false;
			
			while(!exit)
			{
				System.out.println("MENU: \n1.Sign up\n2.SignIn\n3.Display All\n4.Sort donors as per donation amount\n5.Display name of donors who donates monthly\n6.Display donor who donates on the month of april\n0.Exit\n");
				System.out.println("Enter choice: ");
				try
				{
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter donorId, fname, lname, phoneNo, email, password, address,"
								+ " amount,  donationDate,  donationFreq");
						Donor donor=validateAll(map, sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),sc.next(),sc.next());
						map.put(donor.getEmail(), donor);
						System.out.println("Donor registered successfully!");
						break;
						
					case 2:
						System.out.println("Enter Email and Passord to sign in: ");
						validateEmailPass(map,sc.next(),sc.next());
						System.out.println("SignIn Successfully! ");
						break;
						
					case 3:
						System.out.println("Displaying all registered donors:");
						map.values().stream().forEach(s->System.out.println(s));
						break;
					
					case 4:
						System.out.println("Sort donors as per donation amount");
						map.values().stream()
						.sorted((c1,c2)->((Double)c2.getAmount()).compareTo(c1.getAmount()))
						.forEach(s->System.out.println(s));
						break;
						
					case 5:
						System.out.println("Name of donors who donates monthly");
						map.values().stream()
						.filter(s->s.getDonationFreq().equals(DonationFrequency.MONTHLY))
						.map(s->s.getFname())
						.forEach(s->System.out.println(s));
						break;
					
					case 6:
						System.out.println("Displaying donors who donates on the month of april");
						map.values().stream()
						.filter(s->s.getDonationDate().getMonthValue()==4)
						.forEach(s->System.out.println(s));
						break;
						
					case 0:
						exit=true;
						System.out.println("Thank you!!!");
						break;
					}
					
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
