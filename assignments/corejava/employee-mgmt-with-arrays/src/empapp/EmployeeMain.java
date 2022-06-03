package empapp;

import java.nio.file.FileSystemLoopException;
import java.util.Scanner;

import employeeService.EmployeeService;
import employeeService.EmployeeServiceArrImpl;
import exception.EmployeeException;
import model.Employee;

public class EmployeeMain {

	public static void main(String[] args) throws EmployeeException {
		int count = 1;
		System.out.println("enter the size of employee to be added");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		EmployeeServiceArrImpl emSerAryim = new EmployeeServiceArrImpl(size);

		for (int i = 0; i < size; i++) {
			Employee s1 = new Employee();
			System.out.println("enter employee id");
			int empId = scanner.nextInt();
			s1.setEmpId(empId);
			System.out.println("Enter Employee Name ");
			String empName = scanner.next();
			s1.setName(empName);
			System.out.println("Enter Employee Age ");
			int empAge = scanner.nextInt();
			s1.setAge(empAge);
			System.out.println("Enter Employee Designation ");
			String empDesignation = scanner.next();
			s1.setDesignation(empDesignation);
			System.out.println("Enter Employee Department ");
			String empDepartment = scanner.next();
			s1.setDepartment(empDepartment);
			System.out.println("Enter Employee Country ");
			String empCountry = scanner.next();
			s1.setCountry(empCountry);
			emSerAryim.create(s1);

		}

		do {
			System.out.println("1.  Add Employee");
			System.out.println("2.  View Employee");
			System.out.println("3.  Update Employee");
			
		
			System.out.println("Enter the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("The added employee  ");
				Employee s1 = new Employee();
				emSerAryim.addEmployee(s1);
				count++;
				break;
			case 2:
				emSerAryim.ViewAll();
				count++;
				break;
			case 3:
//				
				System.out.println("mention the employee id to be updated");
				Scanner scanner1 = new Scanner(System.in);
				int empId = scanner1.nextInt();
				emSerAryim.update(empId);
				count++;
				break;
			}

		} while (count < 6);
	}
}