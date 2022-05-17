package Day3;
class A10{
	static int a;
	static {
		a=20;
		System.out.println(a);
		
	}
	public static void test(){
		System.out.println(a);
	}
}

public class onlystaticBlock {

	static {
		System.out.println("welcome to static");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("welcome to main");
A10 obj=new A10();
A10.test();
	}

}
