package employeeMain;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import exception.EmployeeException;
import model.Employee;

import service.EmployeeServiceImpl;

public class EmployeeMain  {

	public static void main(String[] args) {
		int count = 0;
		Employee emp = new Employee();
		Random random = new Random();
		int empIdInteger = random.nextInt(20);
		TreeMap<Integer, Employee> mapcrea = new TreeMap<Integer, Employee>();
	
		EmployeeServiceImpl empser = new EmployeeServiceImpl();
		Scanner scanner = new Scanner(System.in);
		
		ExecutorService exeSrvice= Executors.newFixedThreadPool(3);

		do {
			System.out.println("1.  Add Employee");
			System.out.println("2.  View Employee");
			System.out.println("3.  Delete Employee");
			System.out.println("4.  update Employee");
			System.out.println("5.  Import");
			System.out.println("6. Export");

			System.out.println("Enter the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				empIdInteger = empser.createEmployee();
				count++;
				break;
			case 2:

				empser.ViewAll(empIdInteger);
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
			case 4:
				empser.update();
count++;
break;
			case 5:Future<Boolean> future = exeSrvice.submit(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					Thread.sleep(100);
					empser.Import();
					return true;
				}						
			});
		
			break;
			
			case 6:Future<Boolean> future1 = exeSrvice.submit(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					Thread.sleep(200);
					empser.Export();		
					return true;
				}						
			});	
			exeSrvice.shutdown();
			break;
			}
			// TODO Auto-generated method stub

		} while (count < 8);

	}
}