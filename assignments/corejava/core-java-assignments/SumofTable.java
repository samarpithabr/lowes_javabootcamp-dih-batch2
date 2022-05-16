package com.sam;

import java.util.Scanner;

public class SumofTable {

	public static void main(String[] args) {
		int y = 1;
		int sum = 0;
		// TODO Auto-generated method stub
		System.out.println("enter the number of your choice");
		// fetching input from user
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 1; i <= 10; i++) {
			y = n * i;// multiplying number from 1-10

			System.out.println(n + "*" + i + "=" + y);
			sum = sum + y;// adding y to sum
		}

		System.out.println(sum);
	}

}
