package employeeMain;

import java.util.Scanner;

public class EmployeeService {
	Employee[] employee = new Employee[2];
	//employee[0]={32,"ask",3,"sjhdhs","ah","jh"};
	
	Employee s1=new Employee();
	public Employee addEmployee(Employee s) {
		
		 System.out.println("Enter Employee id ");
	     Scanner scanner1=new Scanner(System.in);
	     int empId=scanner1.nextInt();
	     System.out.println("Enter Employee Name ");
	     String empName=scanner1.next();
	     System.out.println("Enter Employee Age ");
	     int empAge=scanner1.nextInt();
	     System.out.println("Enter Employee Designation ");
	     String empDesignation=scanner1.next();
	     System.out.println("Enter Employee Department ");
	     String empDepartment=scanner1.next();
	     System.out.println("Enter Employee Country ");
	     String empCountry=scanner1.next();
	   			s1.setEmpId(empId);
	   			s1.setName(empName);
	   			s1.setAge(empAge);
	   			s1.setDesignation(empDesignation);
	   			s1.setDepartment(empDepartment);
	   			s1.setCountry(empCountry);
	   			System.out.println("Employee added is :");
	   			System.out.println("Emp Id \n"+s1.getEmpId()+"Name \n"+"\t"+s1.getName()+"Age \n"+s1.getDesignation()
	   			+"Department \n"+s1.getDepartment()+"Country \n"+s1.getCountry());
			return s1;	
	}

		
	public void viewEmployee() {
		
		
		
		for(int i=0;i<employee.length;i++) {
			System.out.println(employee[i].getEmpId()+employee[i].getName()+employee[i].getAge()+employee[i].getDesignation()
					+employee[i].getDepartment()+employee[i].getCountry());
		
		}
		
		
	}
	public Employee[] updateEmployee(int id){

		Employee emp=new Employee();
	
	

		if(emp.getEmpId()==id)
		System.out.println(emp.getEmpId()+emp.getName()+emp.getAge()+emp.getDesignation()
				+emp.getDepartment()+emp.getCountry());
	
		
	emp.setAge(id);
	for(int i=0;i<employee.length;i++)
	System.out.println(employee[i].getEmpId()+employee[i].getName()+employee[i].getAge()+employee[i].getDesignation()
			+employee[i].getDepartment()+employee[i].getCountry());
	return employee;
	
		
	}
	
	
}
