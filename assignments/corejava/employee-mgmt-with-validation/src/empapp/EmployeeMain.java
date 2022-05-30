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
	public static boolean validate(Employee emp, Predicate<Employee> validator) {
	
		// emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0
		return validator.test(emp); // executes lambda expression body
	}
	
	public static void handleError(String errorMessage, Consumer<String> consumer)
	{
		consumer.accept(errorMessage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			int count = 0;
			//Employee emp = new Employee();
			Random random = new Random();
			int empIdInteger = random.nextInt(20);
			TreeMap<Integer, Employee> mapcrea = new TreeMap<Integer, Employee>();
			Scanner scanner = new Scanner(System.in);
			// Map<Integer,Employee> map=new TreeMap<>();
			EmployeeServiceImpl empser = new EmployeeServiceImpl();
			
			Employee emp = new Employee();
			Predicate<Employee> validator=(t ->  emp))->{return  emp.getAge()>=10 && emp.getAge()<=60 && emp.getSalary()>0;};
			boolean valStatus =validate(emp,validator);

		

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
					
					count++;
					break;
				case 2:

					empser.viewAll(empIdInteger);
					count++;
					break;

				case 3:

					
						empser.delete(empIdInteger);
					
					count++;
					break;
				case 4:
					empser.update();

				}
				// TODO Auto-generated method stub

			} while (count < 8);

		}

	
	}