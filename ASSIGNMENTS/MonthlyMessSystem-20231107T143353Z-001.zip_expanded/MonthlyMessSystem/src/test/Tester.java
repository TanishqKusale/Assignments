package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import static validation.customerValidation.*;
import static utils.CustomerUtils.*;
import com.core.Customer;
import com.core.Plan;
import exception.CustomerException;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> customer;// = restoreCustomerData();
			boolean exit = false;
			while (!exit) {
				try {

					System.out.println("Enter following Option 1. Sign up Customer\r\n"
							+ "2. If already register then sign in\r\n" + "3. Change Password  \r\n"
							+ "4. Sort Customer  \r\n" + "5. Unsubscribe customer according plan \r\n"
							+ "6. Display all Customers\r\n" + "7. Modify all customers first name  \r\n"
							+ "8. Display email addresses of the customers who did registration in month of January\r\n"
							+ "9. Display count of the Customers who have register for plan: Monthly\r\n"
							+ "10. Search the Customer who lived in Akurdi.\r\n"
							+ "11. Give the 20% discount to the customers who have selected plan for 1 year  \n0. Exit");
					switch (sc.nextInt()) {
					case 1:

						// customer.values().stream().forEach(System.out::println);
						System.out.println(
								"Enter First Name, Last Name, Email, Address, Passowrd,  Phone no, Plan, Amount");
						Customer c = addNewCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), customer);
						customer.put(c.getEmail(), c);
						break;

					case 2:
						System.out.println("Please enter Email and Password");
						ValidateCustomer(customer, sc.next(), sc.next());
						break;

					case 3:
						System.out.println("Please enter Email and Old Password and New Passwords");
						changePassword(customer, sc.next(), sc.next(), sc.next());
						break;

					case 4:
						System.out.println("Sort Customer as per \r\n"
								+ "i) First name     ii) According to plan   iii) According to date of registration\r\n");
						switch (sc.nextInt()) {
						case 1:
							customer.values().stream().sorted((p1, p2) -> p1.getFname().compareTo(p2.getFname()))
									.forEach(System.out::println);
							break;

						case 2:
							customer.values().stream().sorted((s1, s2) -> s1.getMessPlan().compareTo(s2.getMessPlan()))
									.forEach(s -> System.out.println(s));
							break;

						case 3:

							customer.values().stream()
									.sorted((s1, s2) -> s1.getRegisterDate().compareTo(s2.getRegisterDate()))
									.forEach(s -> System.out.println(s));
							break;
						}
						break;
					case 5:
						System.out.println("Enter Plan for Unsubscribe Customer");
						Plan p = Plan.valueOf(sc.next());

						Iterator<Customer> li = customer.values().iterator();
						while (li.hasNext() == true) {

							if (li.next().getMessPlan() == p)
								li.remove();
							else
								throw new CustomerException("Customer does not exists");
						}
						break;

					case 6:
						customer.values().stream().forEach(System.out::println);

						break;

					case 7:
						customer.values().stream()
								.forEach(p2 -> p2.setFname(p2.getFname().replaceFirst(p2.getFname().substring(0, 1),
										p2.getFname().substring(0, 1).toUpperCase())));
						customer.values().stream().forEach(System.out::println);
						break;

					case 8:
						customer.values().stream().filter(s -> s.getRegisterDate().getMonthValue() == 1)
								.map(s -> s.getEmail()).forEach(System.out::println);
						break;

					case 9:
						long count = customer.values().stream().filter(p1 -> p1.getMessPlan().equals(Plan.MONTHLY))
								.count();
						System.out.println("Count = " + count);
						break;

					case 10:
						customer.values().stream().filter(s -> s.getAddress().equals("Akurdi"))
								.forEach(System.out::println);
						break;

					case 11:
						customer.values().stream().filter(s -> s.getMessPlan().equals(Plan.YEARLY))
								.forEach(s -> s.setFinalAmount(0.8 * s.getFinalAmount()));
						System.out.println("Discount Applied!");
						break;

					case 0:
						storeCustomerData(customer);
						exit = true;
						break;
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}
}