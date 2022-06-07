package com.example.empapp.emplyeeMain;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exampl.empapp.config.ConfigSetup;
import com.example.empapp.dao.EmployeeDao;
import com.example.empapp.dao.EmployeeJdbcImpl;
import com.example.empapp.model.Employee;
import com.example.empapp.service.EmployeeService;
import com.example.empapp.service.EmployeeServiceImpl;

import javax.sql.DataSource;

public class EmployeeMain {
	private static Scanner in;
	private static EmployeeServiceImpl empService;
	Employee emp = new Employee();

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSetup.class);
		EmployeeDao empdao = context.getBean("getEmployeeDao", EmployeeDao.class);
		Employee emp = context.getBean("getEmployee", Employee.class);
		System.out.println(context.getBeanDefinitionNames());
		EmployeeService empService = context.getBean("employeeService", EmployeeService.class);
		in = new Scanner(System.in);

		ExecutorService executor = Executors.newCachedThreadPool();

		while (true) {

			System.out.println("\n");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. View All Employees");
			System.out.println("6. Print Statistics");
			System.out.println("7. Import");
			System.out.println("8. Export");
			System.out.println("9. Exit");

			System.out.print("Enter the option: ");
			int option = 0;
			// Get option from user
			try {
				option = Integer.parseInt(in.next());
			} catch (NumberFormatException e) {
				System.out.println("Invalid option. Please enter valid option.");
				continue;
			}
			int empId;
			try {
				switch (option) {
				case 1:

					System.out.println("Enter Employee Name ");
					String empName = in.next();
					emp.setName(empName);
					System.out.println("Enter Employee Age ");
					int empAge = in.nextInt();
					emp.setAge(empAge);
					System.out.println("Enter Employee Designation ");
					String empDesignation = in.next();
					emp.setDesignation(empDesignation);
					System.out.println("Enter Employee Department ");
					String empDepartment = in.next();
					emp.setDepartment(empDepartment);
					System.out.println("Enter Employee Country ");
					String empCountry = in.next();
					emp.setCountry(empCountry);
					empService.create(emp);
					System.out.println("Employee has been added successfully!");
					break;
				case 2:
					System.out.print("Please enter employee id: ");
					empId = in.nextInt();

					printHeader();
					printDetail(emp);
					break;
				case 3:

					System.out.print("Please enter employee id: ");
					empId = in.nextInt();
					Employee empForUpdate = empService.get(empId);
					System.out.println("Enter Employee Name ");
					String empName1 = in.next();
					emp.setName(empName1);
					System.out.println("Enter Employee Age ");
					int empAge1 = in.nextInt();
					emp.setAge(empAge1);
					System.out.println("Enter Employee Designation ");
					String empDesignation1 = in.next();
					emp.setDesignation(empDesignation1);
					System.out.println("Enter Employee Department ");
					String empDepartment1 = in.next();
					emp.setDepartment(empDepartment1);
					System.out.println("Enter Employee Country ");
					String empCountry1 = in.next();
					emp.setCountry(empCountry1);

					empService.update(empForUpdate);

					System.out.println("Employee has been updated successfully!");
					break;
				case 4:
					System.out.print("Please enter employee id: ");
					empId = in.nextInt();
					empService.delete(empId);
					System.out.println("Employee has been deleted successfully!");
					break;
				case 5:
					List<Employee> employees = empService.getAll();
					printHeader();
					for (Employee employee : employees) {
						printDetail(employee);
					}
					break;
				case 6:
					printStatistics();
					break;
				case 7:
					Callable<Boolean> importThread = new Callable<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							System.out.println(Thread.currentThread() + " Waiting for 5s to start import process.");
							Thread.sleep(5000);
							empService.bulkImport();
							return true;
						}
					};

					Future<Boolean> importFuture = executor.submit(importThread);
					System.out.println(Thread.currentThread().getName() + " Import process triggered");

					break;
				case 8:
					Callable<Boolean> exportThread = new Callable<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							System.out.println(Thread.currentThread() + " Waiting for 5s to start export process.");
							Thread.sleep(5000);
							empService.bulkExport();
							return true;
						}
					};

					Future<Boolean> exportFuture = executor.submit(exportThread);
					System.out.println(Thread.currentThread().getName() + " Export process triggered");
					break;
				case 9:
					System.out.println("Thank you!!!");
					executor.shutdown();
					in.close();
					System.exit(0);
					break;

				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter valid input.");
			}
		}

	}

	private static void printStatistics() {

		System.out.println("No of employees older than thirty years: "
				+ empService.getEmployeeCountAgeGreaterThan(e -> e.getAge() > 30));
		System.out.println("List employee IDs older than thirty years: " + empService.getEmployeeIdsAgeGreaterThan(30));
		System.out.println("Employee count by Department: " + empService.getEmployeeCountByDepartment());
		System.out.println("Employee count by Department ordered: " + empService.getEmployeeCountByDepartmentOdered());
		System.out.println("Average Employee Age by Department: " + empService.getAvgEmployeeAgeByDept());
		System.out.println(
				"List Departments have more than 3 employees: " + empService.getDepartmentsHaveEmployeesMoreThan(3));
		System.out.println("List Employees starts with 'S':" + empService.getEmployeeNamesStartsWith("S"));

	}

	private static void printHeader() {
		System.out.format("\n%5s %15s %5s %15s %15s %15s", "EmpID", "Name", "Age", "Designation", "Department",
				"Country");
	}

	private static void printDetail(Employee emp) {
		if (emp == null) {
			return;
		}

		System.out.format("\n%5d %15s %5d %15s %15s %15s", emp.getEmpId(), emp.getName(), emp.getAge(),
				emp.getDesignation(), emp.getDepartment(), emp.getCountry());
	}

}
