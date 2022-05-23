package employeeMain;

import java.util.Scanner;

public class service {
	
	
	//s2[0]= {21,"sam",43,"qew","ad","asd","asda"};
	public static void main(String args[]) {
		Employee[] s2 ;
		//s2[0]=[21,"sam",43,"qew","ad","asd"];
		
		
		EmployeeService empser=new EmployeeService();
		Employee s1=new Employee();
		//System.out.println("empid\n"+"\t"+2+"empid\n"+"\t"+2);
		int count=0;
		
		do {
		System.out.println("1.  Add Employee");
		System.out.println("2.  View Employee");
		System.out.println("3.  Update Employee");
		System.out.println("4.  Delete Employee");
		System.out.println("5.  View All Employee");
		System.out.println("Enter the option: ");
		
		Scanner scanner =new Scanner(System.in);
		int option=scanner.nextInt();
		switch(option) {
		case 1:System.out.println("Enter Employee Details");
	empser.addEmployee(s1);
	count++;
	break;
		case 2: System.out.println("The added employee details ");
		Employee[] employee=null;
		empser.viewEmployee();
		
		count++;
		break;
		case 3:System.out.println("mention the employee id to be updated");
			Scanner scanner1=new Scanner(System.in);
	     int empId=scanner1.nextInt();
	     empser.updateEmployee(empId);
	     break;
}}while(count<6);
}
}
