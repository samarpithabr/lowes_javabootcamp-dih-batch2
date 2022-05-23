package arrays;

public class Assign15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp=0;
		int a[]= {23,54,76,98,34,65};
		System.out.println("initial array is:");
		for(int i=0;i<a.length;i++) {
		
			System.out.println(a[i]);
		}
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				
			}
		}
		
		System.out.println("decresing order of the array is :");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
			if(i==1) {
				System.out.println("2nd largest item in the array :"+a[i]);
				continue;
			}
	
		}
		
	
	}
	

}
