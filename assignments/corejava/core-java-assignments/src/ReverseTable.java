

import java.util.Scanner;

public class ReverseTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Fetching input from user
		System.out.println("enter number of your chaice");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 10; i >= 1; i--) {
			int y = n * i;//multiplying with i in reverse order
			System.out.println(n + "*" + i + "=" + y);
		}
	}

}
