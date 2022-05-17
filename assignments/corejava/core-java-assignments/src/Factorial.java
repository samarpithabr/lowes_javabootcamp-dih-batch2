

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int factorial = 1;
		int i = 1;
		// Fetchng input from user
		System.out.println("enter the number");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (i = n; i > 0; i--) {
			factorial = factorial * i;
		}
		System.out.println("The factorial of the given number is :"+factorial);
	}
	
}
