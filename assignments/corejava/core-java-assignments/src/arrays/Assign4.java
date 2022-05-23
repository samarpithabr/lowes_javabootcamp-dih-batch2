package arrays;
/*to find duplicate array of 0th position to rest of the item stored in j array
 * if array[0] is equal to array[j] where j=1
 * 
 */

public class Assign4 {
	public static int duplicateNumber(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[j] == a[i])
					return a[j];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 23, 76, 56, 76, 79 };
		System.out.println("Duplicate number in the array");
		System.out.println(duplicateNumber(a));

	}

}
