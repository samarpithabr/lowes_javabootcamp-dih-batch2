package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
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

public class EmployeeServiceImpl implements EmployeeService{
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
	@Override
public void ViewAll(int empIdInteger) {
		displayMapEntries(mapcrea.entrySet());
		System.out.println(mapcrea.size());

	}


	public void delete(int empIdInteger) throws EmployeeException {
		System.out.println("enter the id to be deleted");
		int empiid = scanner.nextInt();
		if (empIdInteger == empiid)
			;
		{
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

		mapcrea.replace(empiid, emp);
		System.out.println("Employee with id given deleted");
		System.out.println(mapcrea.size());

	}
@Override
	public int createEmployee() {
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
	
	}

	
	public void Import() {
		System.out.println("Thread Name:" + Thread.currentThread().getName());
		String filePath = "D:\\\\Temp\\\\inputfile.txt";
	
		String line;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
				String[] spell = line.split(",");
				
				if (spell.length >= 0) {
					emp = new Employee();
					emp.setName(spell[0]);
					emp.setAge(Integer.parseInt(spell[1]));
					emp.setDepartment(spell[2]);
					emp.setDesignation(spell[3]);
					emp.setCountry(spell[4]);
				
					mapcrea.put(empIdInteger,emp);
				} else {
					System.out.println("ignoring line: " + line);
					
				}
				System.out.println("Transfer of employee record " + mapcrea.size() );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void Export() {
		System.out.println("Name of the Thread:" + Thread.currentThread().getName());
		FileWriter writer = null;
		try {
			try {
				writer = new FileWriter("output.txt");
				List<Employee> empList = covertLIntoList();
				for (Employee emp : empList) {
					writer.write(empIdInteger + ",");
					writer.write(emp.getName() + ",");
					writer.write(emp.getAge() + ",");
					writer.write(emp.getDepartment() + ",");
					writer.write(emp.getDesignation() + ",");
					writer.write(emp.getCountry() + ",");
					writer.write("\n");
				}
				System.out.println("Transfer of employee record " + mapcrea.size() );
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public List<Employee> covertLIntoList() {
		ArrayList<Employee> empList = new ArrayList<Employee>(mapcrea.values());
		return (List<Employee>) empList;
	}
	


	
}
