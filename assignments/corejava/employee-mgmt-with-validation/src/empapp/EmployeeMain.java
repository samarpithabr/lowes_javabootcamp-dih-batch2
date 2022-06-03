package empapp;

import java.util.EnumMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

import exception.EmployeeException;
import model.Employee;

import service.EmployeeServiceImpl;


public class EmployeeMain {
	

	public static void main(String[] args) {
		Boolean entered=true;
		Employee emp = new Employee();
		Random random = new Random();
		int empIdInteger = random.nextInt(20);
		TreeMap<Integer, Employee> mapcrea = new TreeMap<Integer, Employee>();
		// Map<Integer,Employee> map=new TreeMap<>();
		EmployeeServiceImpl empser = new EmployeeServiceImpl();
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("1.  Add Employee");
			System.out.println("2.  View Employee");
			System.out.println("3.  Delete Employee");
			System.out.println("4.  update Employee");

			System.out.println("Enter the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				
					empIdInteger = empser.createEmployee();
				
			
				break;
			case 2:

				empser.viewAll(empIdInteger);
				
				break;

			case 3:

				
					empser.delete(empIdInteger);
				
				break;
			case 4:
				empser.update();

			}
			// TODO Auto-generated method stub

		} while (entered);

	}
}