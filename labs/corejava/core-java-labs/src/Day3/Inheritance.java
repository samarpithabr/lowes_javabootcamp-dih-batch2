package Day3;
class Employee{
	String empFName;
	String empLastName;
	private int otp;
	int Emplid;
	public void getfullName() {
		System.out.println("firstname "+empFName+"LastName " + empLastName);
	}
}
class FulltimeEmployee extends Employee{
	int eSalary;
	
}
class partTimeEmployee extends Employee{
	int psalary;
	
}

public class Inheritance {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FulltimeEmployee emp=new FulltimeEmployee();
		 emp.empFName="sam";
		 emp.empLastName="arpitha";
	 emp.getfullName();
	
	 
		partTimeEmployee part=new partTimeEmployee();
		 part.empFName="bhavi";
		 part.empLastName="siri";
		part.getfullName();
		

	}

}
