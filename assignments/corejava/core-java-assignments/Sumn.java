package com.sam;

import java.util.Scanner;

public class Sumn {
	public static void main(String args[]) {
		System.out.println("enter number");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = 0;// adding the even number
		int count = 0;// counting n even number
		int i = 0;
		while (n >= count) {
			if (i % 2 == 0) {// checking 1st even number
				count = count + 1;
				sum = sum + i;// adding even number
			}
			i++;
		}
		System.out.println("The sum of "+n+ " given even number is :"+sum);
	}
}
