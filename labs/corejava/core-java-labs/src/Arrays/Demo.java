package Arrays;

public class Demo {
	/*
	 * Arrays are collection of same datatype of items declaration int a=7 for
	 * normal int variable but for array int a[]=new int[5]; int a[]={2,4,5,4};
	 * foreach
	 * 
	 */

	/*
	 * to find min number in integer array
	 * set min=a[0]then compare to next number a[i] then replace a[i] as min
	 * 
	 */
	public static void minNumber(int a[]) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min > a[i])
				min = a[i];
		}
		System.out.println(min);

	}
	/*through method printing in main
	 * 
	 */
	
	public static int[] getarray() {
		return new int[] {10,20,30,40};
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[5];
		a[0] = 23;
		a[1] = 21;
		a[2] = 32;
		a[3] = 43;
		a[4] = 56;
		System.out.println("min number of a array is");
		minNumber(a);
		System.out.println("printing array through method");
		int arr[]=getarray();
		for (int x : arr) {
			System.out.println(x);
		}
		System.out.println("printing");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		/*
		 * 2 dimensional array knowing length of array
		 */
		System.out.println("two dimensional");
		int c[][]= {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(c[i][j]);
			}
			System.out.println( );
		}
		char ch[]= {'h','e','l','l','o'};
		char destinedarrya[]=new char[5];
		System.arraycopy(ch, 0, destinedarrya, 0, 5);
		 System.out.println(String.valueOf(destinedarrya));
		
		
		
	}

}
