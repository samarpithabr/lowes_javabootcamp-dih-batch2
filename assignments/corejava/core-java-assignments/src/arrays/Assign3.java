package arrays;

public class Assign3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b[] = { 42, 78, 543, 987, 675 };
		int max = b[0];
		for (int i = 0; i < b.length; i++) {
			if (max < b[i]) {
				max = b[i];
			}
		}
		System.out.println("The largest number in the array");
		System.out.println(max);
	}

}
