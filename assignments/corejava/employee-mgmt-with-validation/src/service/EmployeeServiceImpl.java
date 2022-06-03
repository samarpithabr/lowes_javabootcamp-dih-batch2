package service;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;

import exception.EmployeeException;
import model.Employee;

public class EmployeeServiceImpl {
	TreeMap<Integer, Employee> mapcrea = new TreeMap<>();
	Scanner scanner = new Scanner(System.in);
	Employee emp = new Employee();
	Random random = new Random();
	Employee s1[];

	int empIdInteger = random.nextInt(20);

	static void displayMapEntries(Set set) {
		Iterator itr = set.iterator();
		System.out.println();
		while (itr.hasNext()) {
			Map.Entry<Integer, Employee> entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " EmpId " + entry.getValue() + " ");
		}

		System.out.println();
	}

	public void viewAll(int empIdInteger) {
		displayMapEntries(mapcrea.entrySet());

	}

	public void delete(int empIdInteger) {
		System.out.println("enter the id to be deleted");
		int empiid = scanner.nextInt();
		if (empIdInteger == empiid)

		{
			mapcrea.remove(empiid);
			System.out.println("Employee with id given deleted");

		}
		else
			System.out.println("E");
	}

	public void update() {
		
		System.out.println("Enter the id to be updated");
		int empiid = scanner.nextInt();	
		System.out.println("Enter the name ");
		String nam = scanner.next();
		emp.setName(nam);
		System.out.println("Enter the age to be updated");
		int empiupdate = scanner.nextInt();
		emp.setAge(empiupdate);
		System.out.println("Enter the designation");
		String desig = scanner.next();
		emp.setDesignation(desig);
		System.out.println("Enter department");
		String dep = scanner.next();
		emp.setDepartment(dep);
		System.out.println("Enter the country");
		String count = scanner.next();
		emp.setCountry(count);
		mapcrea.replace(empiid, emp);
		System.out.println("employee details got updated");
		
			

	}

	public int createEmployee()  {
		Employee emp = new Employee();
		int empIdInteger = random.nextInt(20);
		System.out.println("Enter Employee Name ");
		String empName = scanner.next();
		emp.setName(empName);
		
		boolean ageCheck =true;
		do {
		System.out.println(" enter the Age");
		int age = scanner.nextInt();
		emp.setAge(age);
		ageCheck = validate(emp, employee -> employee.getAge() >= 20 && employee.getAge() <= 60);
		if (ageCheck) {
			System.out.println("employee age is appropriate");
		}
		else 
		{
			System.out.println("enter the employee age between 20 to 60" );
		}
		}while(!ageCheck);
	
		boolean agesalary =true;
		do {
		System.out.println(" enter the Salary");
		int salary = scanner.nextInt();
		emp.setSalary(salary);
		agesalary = validate(emp, employee -> employee.getSalary() >= 2000 && employee.getSalary() <= 6000);
		if (agesalary) {
			System.out.println("salary is appropriate");
		}
		else 
		{
			System.out.println("Enter salary within 2000 to 6000" );
		}
		}while(!agesalary);
		System.out.println("Enter Employee Designation ");
		String empDesignation = scanner.next();
		emp.setDesignation(empDesignation);
		System.out.println("Enter Employee Department ");
		String empDepartment = scanner.next();
		emp.setDepartment(empDepartment);
		System.out.println("Enter Employee Country ");
		String empCountry = scanner.next();
		emp.setCountry(empCountry);
		mapcrea.put(empIdInteger, emp);
		System.out.println(mapcrea.size());
		displayMapEntries(mapcrea.entrySet());
		return empIdInteger;

	}
	public boolean validate(Employee emp,Predicate<Employee> validator) {
		return validator.test(emp);
	}
	
	@SuppressWarnings("rawtypes")
	Comparator EMPLOYEE_SORT_BY_NAME = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1 instanceof Employee && o2 instanceof Employee) {
				return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
			}
			return 0;
		}
	};
	

}
