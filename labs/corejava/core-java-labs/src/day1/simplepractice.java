package day1;

import java.util.Scanner;

public class simplepractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 0, c;
		Scanner scanner = new Scanner(System.in);
		//user can enter variable value of a
		System.out.println("enter the value of variable a");
		a = scanner.nextInt();
		System.out.println(a++);
		/*the value post a gets posti ncremented but later if we call the variable only then it is saved if
		its called as a=a++its value is same never get incremented but a++ called a now it get incremented*/
		System.out.println(a);
		System.out.println("enter the value of variable b");
		b = scanner.nextInt();
		System.out.println(b--);
		System.out.println(b);
		System.out.println("The value of addition " + (a + b));
		System.out.println("The value of subtraction " + (a - b));
		System.out.println("The value of multiplication " + (a * b));
		System.out.println("The value of division " + (a / b));
		System.out.println("The value of remainder" + (a % b));
		System.out.println(a > b && a < 3);
		System.out.println(a > 8 || b == 3);

	}
}
