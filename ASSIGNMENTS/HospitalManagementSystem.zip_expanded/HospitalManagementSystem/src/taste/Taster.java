package taste;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import com.core.*;

import static utils.DoctorUtils.*;

public class Taster {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Doctor> doctor = populateDoctor();
			System.out.println("Enter userId and Password");
			adminSignup(sc.next(), sc.next());
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter 1. Add new Doctor 2. Name of Doctor having Highest Salary"
							+ "\n3. Sort Doctors on the basis of experiance  4. Orthopedics Doctor");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Ente Doctor Id,  Doctor Name, Email, Degree, Joining Date, Salary, Experiance, Department");
						Doctor doc = addDoctor(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.nextInt(), sc.next());
						doctor.put(doc.getDoctId(), doc);
						break;

					case 2:
						String s2 = doctor.values().stream()
								.max((p1, p2) -> ((Double) p1.getSalary()).compareTo(p2.getSalary()))
								.map(s -> s.getDname()).orElseThrow();
						System.out.println(s2);
						break;

					case 3:
						doctor.values().stream()
						.sorted((p1, p2) -> ((Integer)p1.getExperiance()).compareTo(p2.getExperiance()))
						.forEach(s-> System.out.println(s));

						break;
						
					case 4:
						doctor.values().stream()
						.filter(s->s.getDept().equals(Department.ORTHO))
						.forEach(s-> System.out.println(s));

						break;
						

					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
