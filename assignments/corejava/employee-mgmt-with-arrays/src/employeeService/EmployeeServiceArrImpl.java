package employeeService;

import java.util.Scanner;

import exception.EmployeeException;
import model.Employee;

public class EmployeeServiceArrImpl implements EmployeeService {
	Employee s1 = new Employee();
	private Employee[] emp;

	public EmployeeServiceArrImpl(int size) {
		emp = new Employee[size];

	}

	private int index;

	@Override
	public void create(Employee s) {
		// TODO Auto-generated method stub
		emp[index++] = s;
	}

	public void ViewAll() {
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				System.out.println("Emp ID : " + emp[i].getEmpId() + " Emp Name : " + emp[i].getName() + " Emp age  : "
						+ emp[i].getAge() + "Emp Designation   : " + emp[i].getDesignation() + "Emp Department    : "
						+ emp[i].getDepartment() + "Empp Country     :" + emp[i].getCountry());

//			
			}

		}

	}

	public void addEmployee(Employee s) {
		Scanner scanner1 = new Scanner(System.in);
		Employee s1 = new Employee();
		System.out.println("enter employee id");
		int empId = scanner1.nextInt();
		s.setEmpId(empId);
		System.out.println("Enter Employee Name ");
		String empName = scanner1.next();
		s.setName(empName);
		System.out.println("Enter Employee Age ");
		int empAge = scanner1.nextInt();
		s.setAge(empAge);
		System.out.println("Enter Employee Designation ");
		String empDesignation = scanner1.next();
		s.setDesignation(empDesignation);
		System.out.println("Enter Employee Department ");
		String empDepartment = scanner1.next();
		s.setDepartment(empDepartment);
		System.out.println("Enter Employee Country ");
		String empCountry = scanner1.next();
		s.setCountry(empCountry);
		create(s);

	}

	public Employee update(int id) {

		// Employee emp=new Employee();

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < emp.length; i++) {
			if (s1.getEmpId() == id)
				System.out.println("enter the name");
			System.out.println("Enter Employee Name ");
			String empName = sc.next();
			s1.setName(empName);
			System.out.println("Enter Employee Age ");
			int empAge = sc.nextInt();
			s1.setAge(empAge);
			System.out.println("Enter Employee Designation ");
			String empDesignation = sc.next();
			s1.setDesignation(empDesignation);
			System.out.println("Enter Employee Department ");
			String empDepartment = sc.next();
			s1.setDepartment(empDepartment);
			System.out.println("Enter Employee Country ");
			String empCountry = sc.next();

			s1.setCountry(empCountry);
			System.out.println("Name  :" + s1.getName() + "\t" + "Age  :" + s1.getAge() + "\t" + "Designation :"
					+ s1.getDesignation() + "\t" + "Department  :" + s1.getDepartment() + "\t" + "Country :"
					+ s1.getCountry());
		}
		return s1;
	}

}
