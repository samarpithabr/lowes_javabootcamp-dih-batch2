package day7;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a=5;
int b=0;
int c=0;
try{
	 c=a/b;
}catch (ArithmeticException e) {
	// TODO: handle exception
	System.out.println("invalid number");
}
System.out.println(c);
	}

}
