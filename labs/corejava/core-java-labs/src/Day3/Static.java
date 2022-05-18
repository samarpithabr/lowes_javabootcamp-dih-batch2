package Day3;
class Student{
	String name;
	int id;
	static String school="sct";
	static int schoolStrength=30;
	final String schoollocation="mangnalli";
}

public class Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student std=new Student();
std.name="sam";
std.id=92;
std.schoolStrength++;
System.out.println("name  "+std.name+"id  "+std.id+"school  "+Student.school+"SchoolStrength "+Student.schoolStrength  
		+ "schoollocation " +std.schoollocation);
	}

}
