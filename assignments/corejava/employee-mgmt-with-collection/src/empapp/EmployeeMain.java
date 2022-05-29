package empapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import exception.EmployeeException;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceColImpl;

public class EmployeeMain {

	public static void main(String[] args) {
		int count = 0;
		Employee emp = new Employee();
	Random random=new Random();
		int empIdInteger = random.nextInt(20);
		TreeMap<Integer, Employee> mapcrea = new TreeMap<Integer, Employee>();
		// Map<Integer,Employee> map=new TreeMap<>();
		EmployeeServiceColImpl empser = new EmployeeServiceColImpl();
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("1.  Add Employee");
			System.out.println("2.  View Employee");
			System.out.println("3.  Delete Employee");
			System.out.println("4.  update Employee");
			System.out.println("5.  View All Employee");
			System.out.println("Enter the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				try {
					empIdInteger=empser.createEmployee();
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				break;
			case 2:
           
				empser.viewAll(empIdInteger);
			count++;
				break;
		
			case 3:
				
				try {
					empser.delete(empIdInteger);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					System.out.println("Invallid Empid");
				}
				count++;
				break;
			case 4:empser.update();
			
			}
			// TODO Auto-generated method stub

		} while (count < 8);

	}
}