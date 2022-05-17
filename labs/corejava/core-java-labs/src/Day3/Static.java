package Day3;
class Student{
	String name;
	int id;
	static String school="sct";
}

public class Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student std=new Student();
std.name="sam";
std.id=92;
System.out.println("name  "+std.name+"id  "+std.id+"school  "+Student.school);
	}

}
