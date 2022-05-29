package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import exception.EmployeeException;
import model.Employee;

public class EmployeeServiceColImpl {

	TreeMap<Integer, Employee> mapcrea = new TreeMap<>();
	Scanner scanner = new Scanner(System.in);
	Employee emp = new Employee();
	Random random = new Random();

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

	public void viewAll(int empIdInteger ) {
		displayMapEntries(mapcrea.entrySet());
		System.out.println(mapcrea.size());

	}
	

	public void delete(int empIdInteger)throws EmployeeException {
		System.out.println("enter the id to be deleted");
		int empiid = scanner.nextInt();
	if(empIdInteger==empiid);{
	mapcrea.remove(empiid);
			System.out.println("Employee with id given deleted");
			System.out.println(mapcrea.size());
	}
	}
	public void update() {
		System.out.println("enter the id to be updated");
		int empiid = scanner.nextInt();	
		System.out.println("enter the id to be updated");
		int empiupdate = scanner.nextInt();	
		
		
			mapcrea.replace(empiid,emp);
					System.out.println("Employee with id given deleted");
					System.out.println(mapcrea.size());
			
			}
		
	
			

	

	public int createEmployee() throws EmployeeException {
		Employee emp = new Employee();
		int empIdInteger = random.nextInt(20);
		System.out.println("Enter Employee Name ");
		String empName = scanner.next();
		emp.setName(empName);
		System.out.println("Enter Employee Age ");
		int empAge = scanner.nextInt();
		emp.setAge(empAge);
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
		//return mapcrea;
	}
	
}
