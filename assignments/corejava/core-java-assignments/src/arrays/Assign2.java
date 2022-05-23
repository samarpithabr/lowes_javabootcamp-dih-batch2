package arrays;

public class Assign2 {
	/*
	 * either for finding larger or smaller number in array set first array as min and compare to 
	 * rest of the items of array
	 * and take off that min number and display
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 23, 65, 11, 54, 8, 98 };
		int min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		System.out.println("The smallest number in the array ");
		System.out.println(min);
	}

}
