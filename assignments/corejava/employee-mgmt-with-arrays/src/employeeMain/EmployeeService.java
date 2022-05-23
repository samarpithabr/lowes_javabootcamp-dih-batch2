package employeeMain;

import java.util.Scanner;

public class EmployeeService {
	private Employee[] s2 = new Employee[2];
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
	   			System.out.println("Emp Id : "+s1.getEmpId()+"\t"+"Name  :"+s1.getName()+"\t"+"Age  :"+s1.getAge()+"\t"+"Designation :"+s1.getDesignation()
	   			+"\t"+"Department  :"+s1.getDepartment()+"\t"+"Country :"+s1.getCountry());
			return s1;	
	}

		
	public Employee[] viewEmployee() {
		for(int i=0;i<s2.length;i++) {
			System.out.println("Emp Id : "+s2[i].getEmpId()+"\t"+"Name  :"+s2[i].getName()+"\t"+"Age  :"+s2[i].getAge()+"\t"+"Designation :"+s2[i].getDesignation()
   			+"\t"+"Department  :"+s2[i].getDepartment()+"\t"+"Country :"+s2[i].getCountry());
			
		
		}
		
		return s2;
		
	}
	public Employee[] updateEmployee(int id){

		//Employee emp=new Employee();
	
	
for(int i=0;i<s2.length;i++) {
		if(s1.getEmpId()==id) 
	  s1.setAge(id);
	 	System.out.println("Emp Id : "+s1.getEmpId()+"\t"+"Name  :"+s1.getName()+"\t"+"Age  :"+s1.getAge()+"\t"+"Designation :"+s1.getDesignation()
	   			+"\t"+"Department  :"+s1.getDepartment()+"\t"+"Country :"+s1.getCountry());
}
return s2;
	}
	

		
	
	
	
}
