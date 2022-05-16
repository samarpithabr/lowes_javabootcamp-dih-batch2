package com.sam;

import java.util.Scanner;

public class DemoTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the number of your choice");
		//fetching input from user
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 1; i <= 10; i++) {
			int y = n * i;// multiplying number from 1-10
			System.out.println(n + "*" + i + "=" + y);
		}

	}

}
