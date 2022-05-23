package arrays;

public class Assign12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 2, 4 }, { 6, 8, 9 }, { 5, 3, 5 } };
		int b[][] = { { 2, 5, 7 }, { 4, 6, 7 }, { 8, 9, 5 } };
		int c[][] = new int[3][3];
		System.out.println("The multiplication of 2 array");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = 0;
				for (int k = 0; k < 3; k++) {
					c[i][j] = a[i][k] + b[k][j];
				}
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

	}

}