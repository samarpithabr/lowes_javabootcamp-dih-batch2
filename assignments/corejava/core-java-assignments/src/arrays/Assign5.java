package arrays;

/*
 * 
 */
public class Assign5 {
	public static int[] printArray() {
		return new int[] { 23, 54, 76, 87 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("To print the array in the array");
		int array[] = printArray();
		for (int i : array) {
			System.out.println(i);
		}
	}

}
