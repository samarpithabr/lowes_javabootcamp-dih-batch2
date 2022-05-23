import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		System.out.println("Enter the first Number:");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println("Enter the second Number:");
		int y = scanner.nextInt();
		while (count >= 1 && count < 5) {
			System.out.println("select Options");
			System.out.println("Press 1: Addition");
			System.out.println("Press 2: Subtraction");
			System.out.println("Press 3: Multiplication");
			System.out.println("Press 4: Dvision");
			int option = scanner.nextInt();
			count++;
			switch (option) {
			case 1:
				System.out.println("Addition of two numbers " + x + " and " + y + " is " + (x + y));
				break;
			case 2:
				System.out.println("Subtraction of two numbers " + x + " and " + y + " is " + (x - y));
				break;
			case 3:
				System.out.println("Multiplication of two numbers " + x + " and " + y + " is " + (x * y));
				break;
			case 4:
				System.out.println("Dvision of two numbers " + x + " and " + y + " is " + (x / y));
				// Division gives float value it get converted into int implicitly by type
				// casting
				break;
			default:
				System.out.println("enter options properly");
				break;
			}

		}
scanner.close();
	}

}
