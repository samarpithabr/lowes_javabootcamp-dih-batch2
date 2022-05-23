package arrays;

public class Assign11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 2, 4, 6 }, { 3, 6, 7 }, { 5, 3, 4 } };
		int b[][] = { { 1, 3, 4 }, { 4, 7, 6 }, { 5, 8, 9 } };
		int c[][] = new int[3][3];
		System.out.println("Addition of two arrays");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

	}

}
