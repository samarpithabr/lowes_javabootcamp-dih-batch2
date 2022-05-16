package com.sam;

import java.util.Scanner;

public class FactWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int factorial = 1;
		int i = 1;
		//fetching input from data
		System.out.println("enter the number of your choice");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (i <= n) {
			factorial = factorial * i;
			i++;
		}
		System.out.println("The factorial of the given number is : " + factorial);
	}

}
