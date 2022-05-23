package arrays;

public class Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sourceArray[] = { 3, 5, 7, 9, 2 };
		int destArray[] = new int[4];
		System.out.println("first method of copying array");
		System.arraycopy(sourceArray, 0, destArray, 0, 4);// coping from source array to destination array
		for (int i : destArray) {
			System.out.println(i);// displaying items from destination array through system.arraycopy
		}
		System.out.println("second method of copying array");
		int a[] = { 23, 76, 43, 87 };
		int b[] = a.clone();// copying to array b done by cloning of a
		for (int i : b) {
			System.out.println(i);
		}

	}

}
