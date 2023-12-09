package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;
import com.core.Plan;

public class CustomerUtils {

	public static HashMap<String, Customer> populateCustomer() {
		HashMap<String, Customer> cust = new HashMap<>();
//		String fname, String lname, String email, String address,
//		LocalDate endPlanDate, String phoneNo, Plan messPlan, double finalAmount
		cust.put("abc@123", new Customer("tejas", "Tara", "abc@123", "asdf", "Pune", LocalDate.parse("1998-03-05"),
				LocalDate.parse("1998-09-05"), "8208300420", Plan.valueOf("MONTHLY"), 3000));
		cust.put("xyz@344",
				new Customer("siddhant", "Kolkar", "xyz@344", "qwer", "Jalna", LocalDate.parse("1997-09-05"),
						LocalDate.parse("1998-12-25"), "8569745635", Plan.valueOf("YEARLY"), 32000));
		cust.put("pqr@789", new Customer("Rushi", "Tara", "pqr@789", "asdf", "Akurdi", LocalDate.parse("2003-01-27"),
				LocalDate.parse("2021-01-14"), "9850920850", Plan.valueOf("QUARTARLY"), 11700));
		return cust;
	}

	@SuppressWarnings("unchecked")//deseralization
	public static HashMap<String, Customer> restoreCustomerData() throws ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customerData.ser"))) {

			return (HashMap<String, Customer>) ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Populated Map Created");
			return populateCustomer();
			

		}
	}
	
	
	public static void storeCustomerData(Map<String, Customer> cust) throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("customerData.ser"))){
			oos.writeObject(cust);
		}
	}

}
