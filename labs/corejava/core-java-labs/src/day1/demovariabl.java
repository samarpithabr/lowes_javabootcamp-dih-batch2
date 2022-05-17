package day1;
class Test{
	int a=7;//instance variable
	static int b=9;//static variable
	public void add() {
		int x=13;//local variable
		System.out.println(x);
	}
	
}
public class demovariabl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Test obj=new Test();
System.out.println(obj.b);
System.out.println(obj.a);
obj.add();


	}

}
