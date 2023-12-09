package com.test;

import java.nio.file.attribute.AclEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import static validation.customerValidation.*;
import static utils.CustomerUtils.*;
import com.core.Customer;
import com.core.Plan;
import exception.CustomerException;

public class Tester {
	try(Scanner sc=new Scanner (System.in))
	{
		HashMap<String, Customer> customer= restoreCustomerData();
		boolean exit=false;
		while(!exit) {
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}catch(Exception a)
	{
		a.printStackTrace();
	}
	}

}
